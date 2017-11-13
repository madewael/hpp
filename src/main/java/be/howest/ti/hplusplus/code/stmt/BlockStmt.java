package be.howest.ti.hplusplus.code.stmt;

import be.howest.ti.hplusplus.exceptions.HppAppException;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppObject;
import be.howest.ti.hplusplus.values.HppValue;

import java.util.List;

public class BlockStmt extends Statement {
    final List<Statement> stmts;
    public BlockStmt(List<Statement> stmts){
        if( stmts==null) throw new HppAppException("Stmt list cannot be null");
        this.stmts=stmts;
    }

    @Override
    public void eval(HppScope<HppValue> scope) {
        stmts.stream().forEach(stmt->stmt.eval(scope));
    }
}
