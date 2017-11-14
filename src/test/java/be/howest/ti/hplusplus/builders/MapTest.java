package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.code.stmt.Statement;
import be.howest.ti.hplusplus.scopes.BaseScope;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppInt;
import be.howest.ti.hplusplus.values.HppMap;
import be.howest.ti.hplusplus.values.HppValue;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class MapTest {

    @Test
    public void testCreateMapOfStringToInt(){
        HppProgram p = new HppProgram();
        Statement stmt = HppParser.parseStmt("m : string to int.").accept(new StatementBuilder(p));
        HppScope<HppValue> s = new BaseScope<HppValue>(p);
        stmt.eval(s);
        try {
            HppMap val = (HppMap) s.get("m");
        } catch (ClassCastException ex){
            fail("Expected 's' to be a sequence");
        }
    }

    @Test
    public void testAddAndGetPair(){
        HppProgram p = new HppProgram();
        Statement stmt = HppParser.parseStmt(
                "(: m: string to int. do put of m with \"m\",1.x << do get of m with \"m\".:)")
                .accept(new StatementBuilder(p));
        HppScope<HppValue> s = new BaseScope<HppValue>(p);
        s.add("x", new HppInt(0));
        stmt.eval(s);

        HppInt res = (HppInt) s.get("x");
        assertEquals(1, res.getIntValue());
    }
}
