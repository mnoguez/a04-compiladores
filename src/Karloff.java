/* Generated By:JavaCC: Do not edit this line. Karloff.java */
import java.io.*;
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

public class Karloff implements KarloffConstants {

  public static void main(String args[]) throws ParseException,IOException {

    Karloff parser = new Karloff(new FileInputStream(args[0]));
    //parser.Karloff();

    ArvoreKarloff arvore = parser.Karloff();
    pprint(arvore);
  }

  static void pprint(ArvoreKarloff arvore){
    pprintMain(arvore.main);
    pprintFunc(arvore.funcs);
  }

  static void pprintMain(Main main){
    System.out.print("void main {\u005cn");
    pprintVarDecl(main.varDecl);
    pprintSeqComandos(main.seqComandos);
    System.out.print("}\u005cn");
  }

  static void pprintVarDecl(ArrayList<Decl> varDecl){
    for(Decl decl : varDecl){
        System.out.print("newVar ");
        pprintTipo(decl.tipo);
        System.out.print(" ");
        System.out.print(decl.var);
        System.out.print(";\u005cn");
    }
  }

  static void pprintTipo(Tipo tipo){
    if(tipo instanceof Int)
        System.out.print( ((Int) tipo).n);
    else
        System.out.print( ((Bool) tipo).bool);
  }

  static void pprintSeqComandos(ArrayList<Comando> comandos){
    for(Comando comando : comandos){
        pprintComando(comando);
    }
  }

  static void pprintComando(Comando comando){
    if(comando instanceof Atrib){
        System.out.print( ((Atrib) comando).var + " = ");
        pprintListaExp( ((Atrib) comando).exp);
        System.out.print(";\u005cn");
    }else if(comando instanceof ChamadaDeFuncao){
        System.out.print( ((ChamadaDeFuncao) comando).var + " ( ");
        pprintListaExp( ((ChamadaDeFuncao) comando).listaExp);
        System.out.print(" );\u005cn");
    }else if(comando instanceof If){
        System.out.print("if ( ");
        pprintExp( ((If) comando).exp);
        System.out.print(" ) then {\u005cn");
        pprintSeqComandos( ((If) comando).seqComandos);
        System.out.print("};\u005cn");
    }else if(comando instanceof While){
        System.out.print("while ( ");
        pprintExp( ((While) comando).exp);
        System.out.print(" ) {\u005cn");
        pprintSeqComandos( ((While) comando).seqComandos);
        System.out.print("};\u005cn");
    }else if(comando instanceof Repeat){
        System.out.print("repeat {\u005cn");
        pprintSeqComandos( ((Repeat) comando).seqComandos);
        System.out.print("} until ( ");
        pprintExp( ((Repeat) comando).exp);
        System.out.print(" );\u005cn");
    }else if(comando instanceof Return){
        System.out.print("return ");
        pprintExp( ((Return) comando).exp);
        System.out.print(";\u005cn");
    }else if(comando instanceof Sout){
        System.out.print("System.output(");
        pprintExp( ((Sout) comando).exp);
        System.out.print(");\u005cn");
    }
  }

  static void pprintExp(Exp exp){
    if(exp instanceof Op){
        pprintOp((Op) exp);
    }
    else
        pprintFator((Fator) exp);
  }

  static void pprintOp(Op op){
    System.out.print("( ");
    pprintExp(op.a);
    System.out.print(" " + op.op + " ");
    pprintExp(op.b);
    System.out.print(" )");
  }

  static void pprintFator(Fator fator){
    if(fator instanceof Id){
        System.out.print( ((Id) fator).var);
    }else if(fator instanceof FuncFator){
        System.out.print( ((FuncFator) fator).var + "( ");
        pprintListaExp( ((FuncFator) fator).exps);
        System.out.print(" )");
    }else if(fator instanceof Num){
        System.out.print( ((Num) fator).num);
    }else if(fator instanceof True){
        System.out.print( ((True) fator).t);
    }else if(fator instanceof False){
        System.out.print( ((False) fator).f);
    }
  }

  static void pprintListaExp(ArrayList<Exp> exps){
    int i;
    for(i = 0; i < exps.size(); i++){
        if(i > 0)
            System.out.print(", ");
        pprintExp(exps.get(i));
    }
  }

  static void pprintFunc(ArrayList<Func> funcs){
    for(Func func : funcs){
        System.out.print("func ");
        pprintTipo(func.tipo);
        System.out.print(" " + func.var + " (");
        pprintListaArg(func.listaArg);
        System.out.print(" ) {\u005cn");
        pprintVarDecl(func.varDecl);
        pprintSeqComandos(func.seqComandos);
        System.out.print("}\u005cn");
    }
  }

  static void pprintListaArg(ArrayList<Arg> args){
    int i;
    for(i = 0; i < args.size(); i++){
        if(i > 0)
            System.out.print(", ");
        pprintTipo(args.get(i).tipo);
        System.out.print(" " + (args.get(i)).var);
    }
  }

  static final public ArvoreKarloff Karloff() throws ParseException {
 Main main = null; ArrayList<Func> funcs = null;
    main = Main();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FUNC:
      funcs = Func();
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    jj_consume_token(0);
     {if (true) return new ArvoreKarloff(main, funcs);}
    throw new Error("Missing return statement in function");
  }

  static final public Main Main() throws ParseException {
 ArrayList<Decl> varDecl; ArrayList<Comando> seqComandos;
    jj_consume_token(VOID);
    jj_consume_token(MAIN);
    jj_consume_token(ACHAVES);
    varDecl = VarDecl();
    seqComandos = SeqComandos();
    jj_consume_token(FCHAVES);
     {if (true) return new Main(varDecl, seqComandos);}
    throw new Error("Missing return statement in function");
  }

  static final public ArrayList<Decl> VarDecl() throws ParseException {
 ArrayList<Decl> varDecl = new ArrayList<Decl>(); Token id = null; Tipo tipo = null;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NVAR:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      jj_consume_token(NVAR);
      tipo = Tipo();
      id = jj_consume_token(ID);
      jj_consume_token(PV);
                                          varDecl.add(new Decl(tipo, id.image));
    }
     {if (true) return varDecl;}
    throw new Error("Missing return statement in function");
  }

  static final public Tipo Tipo() throws ParseException {
 Token t1 = null; Token t2 = null; Tipo t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      t1 = jj_consume_token(INT);
                 t = new Int(t1.image);
      break;
    case BOOL:
      t2 = jj_consume_token(BOOL);
                   t = new Bool(t2.image);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public ArrayList<Comando> SeqComandos() throws ParseException {
 ArrayList<Comando> comandos = new ArrayList<Comando>(); Comando c = null;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case REPEAT:
      case RETURN:
      case SOUT:
      case ID:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      c = Comando();
                    comandos.add(c);
    }
     {if (true) return comandos;}
    throw new Error("Missing return statement in function");
  }

  static final public Comando Comando() throws ParseException {
 Comando comando; Token id = null; Exp exp = null; ArrayList<Comando> comandos = null; ArrayList<Exp> listaExp = new ArrayList<Exp>();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      id = jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IGUAL:
        jj_consume_token(IGUAL);
        exp = Exp();
        jj_consume_token(PV);
                                          listaExp.add(exp);
        break;
      case APAR:
        jj_consume_token(APAR);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case APAR:
        case TRUE:
        case FALSE:
        case ID:
        case NUM:
          listaExp = ListaExp();
          break;
        default:
          jj_la1[4] = jj_gen;
          ;
        }
        jj_consume_token(FPAR);
        jj_consume_token(PV);
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
                                                                                                              comando = new Atrib(id.image, listaExp);
      break;
    case IF:
      jj_consume_token(IF);
      jj_consume_token(APAR);
      exp = Exp();
      jj_consume_token(FPAR);
      jj_consume_token(THEN);
      jj_consume_token(ACHAVES);
      comandos = SeqComandos();
      jj_consume_token(FCHAVES);
      jj_consume_token(PV);
                                                                                               comando = new If(exp, comandos);
      break;
    case WHILE:
      jj_consume_token(WHILE);
      jj_consume_token(APAR);
      exp = Exp();
      jj_consume_token(FPAR);
      jj_consume_token(ACHAVES);
      comandos = SeqComandos();
      jj_consume_token(FCHAVES);
      jj_consume_token(PV);
                                                                                           comando = new While(exp, comandos);
      break;
    case REPEAT:
      jj_consume_token(REPEAT);
      jj_consume_token(ACHAVES);
      comandos = SeqComandos();
      jj_consume_token(FCHAVES);
      jj_consume_token(UNTIL);
      jj_consume_token(APAR);
      exp = Exp();
      jj_consume_token(FPAR);
      jj_consume_token(PV);
                                                                                                    comando = new Repeat(exp, comandos);
      break;
    case RETURN:
      jj_consume_token(RETURN);
      exp = Exp();
      jj_consume_token(PV);
                                 comando = new Return(exp);
      break;
    case SOUT:
      jj_consume_token(SOUT);
      jj_consume_token(APAR);
      exp = Exp();
      jj_consume_token(FPAR);
      jj_consume_token(PV);
                                             comando = new Sout(exp);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return comando;}
    throw new Error("Missing return statement in function");
  }

  static final public Exp Exp() throws ParseException {
 Exp a = null, b = null, exp; Fator f = null; Token op = null; Op o;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case APAR:
      jj_consume_token(APAR);
      a = Exp();
      op = jj_consume_token(OP);
      b = Exp();
      jj_consume_token(FPAR);
                                                  o = new Op(a, op.image, b); exp = o;
      break;
    case TRUE:
    case FALSE:
    case ID:
    case NUM:
      f = Fator();
                   exp = f;
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return exp;}
    throw new Error("Missing return statement in function");
  }

  static final public Fator Fator() throws ParseException {
 Token t = null; ArrayList<Exp> exps = new ArrayList<Exp>(); Fator f = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      t = jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case APAR:
        jj_consume_token(APAR);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case APAR:
        case TRUE:
        case FALSE:
        case ID:
        case NUM:
          exps = ListaExp();
          break;
        default:
          jj_la1[8] = jj_gen;
          ;
        }
        jj_consume_token(FPAR);
        break;
      default:
        jj_la1[9] = jj_gen;
        ;
      }
        if(exps.isEmpty())
            f = new Id(t.image);
        else
            f = new FuncFator(t.image, exps);
      break;
    case NUM:
      t = jj_consume_token(NUM);
                 f = new Num(t.image);
      break;
    case TRUE:
      t = jj_consume_token(TRUE);
                  f = new True(t.image);
      break;
    case FALSE:
      t = jj_consume_token(FALSE);
                   f = new False(t.image);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return f;}
    throw new Error("Missing return statement in function");
  }

  static final public ArrayList<Exp> ListaExp() throws ParseException {
 ArrayList<Exp> exps = new ArrayList<Exp>(); Exp exp1 = null, exp2 = null;
    exp1 = Exp();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[11] = jj_gen;
        break label_3;
      }
      jj_consume_token(VIRGULA);
      exp2 = Exp();
    }
        exps.add(exp1);

        if(exp2 != null)
            exps.add(exp2);
     {if (true) return exps;}
    throw new Error("Missing return statement in function");
  }

  static final public ArrayList<Func> Func() throws ParseException {
 ArrayList<Func> funcs = new ArrayList<Func>(); Tipo t = null; Token id = null; ArrayList<Arg> args = null; ArrayList<Decl> decls = null; ArrayList<Comando> comandos = null;
    label_4:
    while (true) {
      jj_consume_token(FUNC);
      t = Tipo();
      id = jj_consume_token(ID);
      jj_consume_token(APAR);
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INT:
        case BOOL:
          ;
          break;
        default:
          jj_la1[12] = jj_gen;
          break label_5;
        }
        args = ListaArg();
      }
      jj_consume_token(FPAR);
      jj_consume_token(ACHAVES);
      decls = VarDecl();
      comandos = SeqComandos();
      jj_consume_token(FCHAVES);
     funcs.add(new Func(t, id.image, args, decls, comandos));
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FUNC:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_4;
      }
    }
     {if (true) return funcs;}
    throw new Error("Missing return statement in function");
  }

  static final public ArrayList<Arg> ListaArg() throws ParseException {
 ArrayList<Arg> args = new ArrayList<Arg>(); Tipo tipo1 = null; Tipo tipo2 = null; Token id1 = null; Token id2 = null;
    tipo1 = Tipo();
    id1 = jj_consume_token(ID);
                               args.add(new Arg(tipo1, id1.image));
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[14] = jj_gen;
        break label_6;
      }
      jj_consume_token(VIRGULA);
      tipo2 = Tipo();
      id2 = jj_consume_token(ID);
        if(tipo2 != null && id2 != null)
            args.add(new Arg(tipo2, id2.image));
    }
     {if (true) return args;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public KarloffTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x4000000,0x200,0x1800,0x106d0000,0x31804000,0x6000,0x106d0000,0x31804000,0x31804000,0x4000,0x31800000,0x2000000,0x1800,0x4000000,0x2000000,};
   }

  /** Constructor with InputStream. */
  public Karloff(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Karloff(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new KarloffTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Karloff(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new KarloffTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Karloff(KarloffTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(KarloffTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[30];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 15; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 30; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
