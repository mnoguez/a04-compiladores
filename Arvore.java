import java.util.ArrayList;

class ArvoreKarloff{
    Main main;
    ArrayList<Func> funcs;

    ArvoreKarloff(Main main, ArrayList<Func> funcs){
        this.main = main;
        this.funcs = funcs;
    }
}

class Main{
    ArrayList<Decl> varDecl;
    ArrayList<Comando> seqComandos;

    Main(ArrayList<Decl> varDecl, ArrayList<Comando> seqComandos){
        this.varDecl = varDecl;
        this.seqComandos = seqComandos;
    }
}

class Decl{
    Tipo tipo;
    String var;

    Decl(Tipo tipo, String var){
        this.tipo = tipo;
        this.var = var;
    }
}

class Tipo{}

class Int extends Tipo{
    String n;

    Int(String n){
        this.n = n;
    }
}

class Bool extends Tipo{
    String bool;

    Bool(String bool){
        this.bool = bool;
    }
}

class Comando{}

class Atrib extends Comando{
    String var;
    ArrayList<Exp> exp;

    Atrib(String var, ArrayList<Exp> exp){
        this.var = var;
        this.exp = exp;
    }
}

class ChamadaDeFuncao extends Comando{
    String var;
    ArrayList<Exp> listaExp;

    ChamadaDeFuncao(String var, ArrayList<Exp> listaExp){
        this.var = var;
        this.listaExp = listaExp;
    }
}

class If extends Comando{
    Exp exp;
    ArrayList<Comando> seqComandos;

    If(Exp exp, ArrayList<Comando> seqComandos){
        this.exp = exp;
        this.seqComandos = seqComandos;
    }
}

class While extends Comando{
    Exp exp;
    ArrayList<Comando> seqComandos;

    While(Exp exp, ArrayList<Comando> seqComandos){
        this.exp = exp;
        this.seqComandos = seqComandos;
    }
}

class Repeat extends Comando{
    Exp exp;
    ArrayList<Comando> seqComandos;

    Repeat(Exp exp, ArrayList<Comando> seqComandos){
        this.exp = exp;
        this.seqComandos = seqComandos;
    }
}

class Return extends Comando{
    Exp exp;

    Return(Exp exp){
        this.exp = exp;
    }
}

class Sout extends Comando{
    Exp exp;

    Sout(Exp exp){
        this.exp = exp;
    }
}

class Exp{}

class Op extends Exp{
    Exp a;
    String op;
    Exp b;

    Op(Exp a, String op, Exp b){
        this.a = a;
        this.op = op;
        this.b = b;
    }
}

class Fator extends Exp{}

class Id extends Fator{
    String var;

    Id(String var){
        this.var = var;
    }
}

class FuncFator extends Fator{
    String var;
    ArrayList<Exp> exps;

    FuncFator(String var, ArrayList<Exp> exps){
        this.var = var;
        this.exps = exps;
    }
}

class Num extends Fator{
    String num;

    Num(String num){
        this.num = num;
    }
}

class True extends Fator{
    String t;

    True(String t){
        this.t = t;
    }
}

class False extends Fator{
    String f;

    False(String f){
        this.f = f;
    }
}

class Soma extends Op{
    Soma(Exp a, Exp b){
        super(a, b);
    }
}

class Sub extends Op{
    Sub(Exp a, Exp b){
        super(a, b);
    }
}

class Mult extends Op{
    Mult(Exp a, Exp b){
        super(a, b);
    }
}

class Div extends Op{
    Div(Exp a, Exp b){
        super(a, b);
    }
}

class And extends Op{
    And(Exp a, Exp b){
        super(a, b);
    }
}

class Or extends Op{
    Or(Exp a, Exp b){
        super(a, b);
    }
}

class Maior extends Op{
    Maior(Exp a, Exp b){
        super(a, b);
    }
}

class Menor extends Op{
    Menor(Exp a, Exp b){
        super(a, b);
    }
}

class Igual extends Op{
    Igual(Exp a, Exp b){
        super(a, b);
    }
}

class Func{
    Tipo tipo;
    String var;
    ArrayList<Arg> listaArg;
    ArrayList<Decl> varDecl;
    ArrayList<Comando> seqComandos;

    Func(Tipo tipo, String var, ArrayList<Arg> listaArg, ArrayList<Decl> varDecl, ArrayList<Comando> seqComandos){
        this.tipo = tipo;
        this.var = var;
        this.listaArg = listaArg;
        this.varDecl = varDecl;
        this.seqComandos = seqComandos;
    }
}

class Arg{
    Tipo tipo;
    String var;

    Arg(Tipo tipo, String var){
        this.tipo = tipo;
        this.var = var;
    }
}
