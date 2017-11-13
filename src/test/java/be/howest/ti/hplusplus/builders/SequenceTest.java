package be.howest.ti.hplusplus.builders;

import be.howest.ti.hplusplus.code.HppProgram;
import be.howest.ti.hplusplus.code.stmt.Statement;
import be.howest.ti.hplusplus.scopes.BaseScope;
import be.howest.ti.hplusplus.scopes.HppScope;
import be.howest.ti.hplusplus.values.HppInt;
import be.howest.ti.hplusplus.values.HppSequence;
import be.howest.ti.hplusplus.values.HppValue;
import org.junit.Test;

import static org.junit.Assert.*;


public class SequenceTest {

    @Test
    public void testCreateSequenceOfInt(){
        HppProgram p = new HppProgram();
        Statement stmt = HppParser.parseStmt("s : ints.").accept(new StatementBuilder(p));
        HppScope<HppValue> s = new BaseScope<HppValue>(p);
        stmt.eval(s);
        try {
            HppSequence val = (HppSequence) s.get("s");
        } catch (ClassCastException ex){
            fail("Expected 's' to be a sequence");
        }

    }

    @Test
    public void testEmptySequenceSize(){
        HppProgram p = new HppProgram();
        Statement stmt = HppParser.parseStmt("(: s : ints. x << do size of s. :)").accept(new StatementBuilder(p));
        HppScope<HppValue> s = new BaseScope<HppValue>(p);
        s.add("x", new HppInt(123));
        stmt.eval(s);

        HppInt res = (HppInt) s.get("x");
        assertEquals(0, res.getIntValue());

    }

    @Test
    public void testAddElement(){
        HppProgram p = new HppProgram();
        Statement stmt = HppParser.parseStmt("(: s : ints. do add of s with 1.x << do size of s. :)").accept(new StatementBuilder(p));
        HppScope<HppValue> s = new BaseScope<HppValue>(p);
        s.add("x", new HppInt(123));
        stmt.eval(s);

        HppInt res = (HppInt) s.get("x");
        assertEquals(1, res.getIntValue());
    }

    @Test
    public void testAddMoreElement(){
        HppProgram p = new HppProgram();
        Statement stmt = HppParser.parseStmt("(: s : ints. do add of s with 1,2,3.x << do size of s. :)").accept(new StatementBuilder
                (p));
        HppScope<HppValue> s = new BaseScope<HppValue>(p);
        s.add("x", new HppInt(123));
        stmt.eval(s);

        HppInt res = (HppInt) s.get("x");
        assertEquals(3, res.getIntValue());
    }

    @Test
    public void testGetMoreElement(){


        HppProgram p = new HppProgram();
        Statement stmt = HppParser.parseStmt(String.format("(: s : ints. do add of s with 1,2,3. show s. %s %s %s :)",
                String.format("%s << do get of s with %d.","ea",0),
                String.format("%s << do get of s with %d.","eb",1),
                String.format("%s << do get of s with %d.","ec",2)))
                .accept
                (new
                StatementBuilder
                (p));
        HppScope<HppValue> s = new BaseScope<HppValue>(p);
        s.add("ea", new HppInt(123));
        s.add("eb", new HppInt(123));
        s.add("ec", new HppInt(123));
        stmt.eval(s);

        HppInt ea = (HppInt) s.get("ea");
        assertEquals(1, ea.getIntValue());
        HppInt eb = (HppInt) s.get("eb");
        assertEquals(2, eb.getIntValue());
        HppInt ec = (HppInt) s.get("ec");
        assertEquals(3, ec.getIntValue());
    }

}
