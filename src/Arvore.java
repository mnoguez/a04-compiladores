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
    int n;

    Int(int n){
        this.n = n;
    }
}

class Bool extends Tipo{
    boolean bool;

    Bool(boolean bool){
        this.bool = bool;
    }
}

class Comando{}

class Atrib extends Comando{
    String var;
    Exp exp;

    Atrib(String var, Exp exp){
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

class Op extends Exp{}

class Soma extends Op{
    Exp a;
    Exp b;

    Soma(Exp a, Exp b){
        this.a = a;
        this.b = b;
    }
}

class Sub extends Op{
    Exp a;
    Exp b;

    Sub(Exp a, Exp b){
        this.a = a;
        this.b = b;
    }
}

class Mult extends Op{
    Exp a;
    Exp b;

    Mult(Exp a, Exp b){
        this.a = a;
        this.b = b;
    }
}

class Div extends Op{
    Exp a;
    Exp b;

    Div(Exp a, Exp b){
        this.a = a;
        this.b = b;
    }
}

class And extends Op{
    Exp a;
    Exp b;

    And(Exp a, Exp b){
        this.a = a;
        this.b = b;
    }
}

class Or extends Op{
    Exp a;
    Exp b;

    Or(Exp a, Exp b){
        this.a = a;
        this.b = b;
    }
}

class Maior extends Op{
    Exp a;
    Exp b;

    Maior(Exp a, Exp b){
        this.a = a;
        this.b = b;
    }
}

class Menor extends Op{
    Exp a;
    Exp b;

    Menor(Exp a, Exp b){
        this.a = a;
        this.b = b;
    }
}

class Igual extends Op{
    Exp a;
    Exp b;

    Igual(Exp a, Exp b){
        this.a = a;
        this.b = b;
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
