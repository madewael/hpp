package be.howest.ti.hplusplus.code.expr;

import be.howest.ti.hplusplus.exceptions.compile.HppTypeCheckException;
import be.howest.ti.hplusplus.exceptions.execution.HppExecutionException;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.types.HppType;
import be.howest.ti.hplusplus.values.HppBool;
import be.howest.ti.hplusplus.values.HppInt;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

public class BinOperation extends Expression {
    final Expression exprL;
    final String op;
    final Expression exprR;

    public BinOperation(Expression exprL, String op, Expression exprR){
        this.exprL = exprL;
        this.op = op;
        this.exprR = exprR;
    }

    public HppValue eval(HppScope<HppValue> scope){
        HppValue l = exprL.eval(scope);
        HppValue r = exprR.eval(scope);

        switch(op){
            case "+": return new HppInt( l.getIntValue()+r.getIntValue() );
            case "-": return new HppInt( l.getIntValue()-r.getIntValue() );
            case "*": return new HppInt( l.getIntValue()*r.getIntValue() );
            case "/": return new HppInt( l.getIntValue()/r.getIntValue() );
            case "<": return (l.getIntValue()<r.getIntValue())? HppBool.YES:HppBool.NO;
            case ">": return (l.getIntValue()>r.getIntValue())? HppBool.YES:HppBool.NO;

            default: throw new HppExecutionException("Unsupported Operation:" + op);
        }

    }

    @Override
    public HppType determineType(HppScope<HppType> typeScope) {
        HppType l = exprL.checkType(typeScope);
        HppType r = exprR.checkType(typeScope);

        HppType el = null;
        HppType er = null;
        HppType ex = null;

        switch(op){
            case "+":
            case "-":
            case "*":
            case "/":
            case ">":
            case "<": el = HppType.INT; er = HppType.INT; ex = HppType.INT;break;

            case "and":
            case "or": el = HppType.BOOL; er = HppType.BOOL; ex = HppType.BOOL; break;

            default: throw new HppExecutionException("Unsupported Operation:" + op);
        }

        if ( l==el && r==el){
            return ex;
        } else {
            throw new HppTypeCheckException(String.format("Binairy op %s expects %s and %s as operant types, found " +
                    "(%s and %s)", op, el, er, l, r));
        }




    }

    public String toString(){
        return String.format("%s: (%s %s %s) ", this.getClass().getSimpleName(),
                exprL, op ,exprR);
    }
}
