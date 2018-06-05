package Scanner;
import java.io.*;
import Parser.*;
import java_cup.runtime.Symbol;

%%
%class Lexer
%public
//%function next_token
%type Token
%line
%ignorecase
%cup

%{
//metodo para crear token
	Symbol symbolo(int type){
	return new Symbol(type,yyline,yycolumn);
}

//metodo para crear token con valor
	Symbol symbolo(int type, Object value){
	return new Symbol(type, yyline, yycolumn,value);
}
%}
//definición de tokens
Letras = [a-zA-Z]
Numero = ([0-9]|[1-9][0-9]*)
//espacios en blanco
WHITE=[ \t\r\n]


%%


{WHITE}* "VOID" {return symbolo(sym.VOID);}
{WHITE}* "INT" {return symbolo(sym.INT);}


//creo un token del tipo Numero, con un valor inicial
{Numero} {return symbolo(sym.NUM, yytext());}
//creo un token del tipo ID con un valor inicial
[a-z](([a-zA-Z]|(0|[1-9][0-9]*))|_([a-zA-Z]|(0|[1-9][0-9]*)))* {return symbolo(sym.ID, yytext());}


//todos los paréntesis
{WHITE}*"(" { return symbolo(sym.PARENIZQ);}
{WHITE}*"[" { return symbolo(sym.CORCHETEIZQ);}
{WHITE}*"{" { return symbolo(sym.LLAVEIZQ);}
{WHITE}*"}" { return symbolo(sym.LLAVEDER);}
{WHITE}*"]" { return symbolo(sym.CORCHETEDER);}
{WHITE}*")" { return symbolo(sym.PARENDER);}

//condicionales

{WHITE}*"ELSE" {return symbolo(sym.ELSE);}
{WHITE}*"IF" {return symbolo(sym.IF);}

//comentario


//puntuacion
{WHITE}*"," {return symbolo(sym.COMA);}
{WHITE}*";" {return symbolo(sym.PUNTOCOMA);}

{WHITE}* "::=" {return symbolo(sym.ASIGNACION);}

//operadores aritmeticos
{WHITE}* "*" {return symbolo(sym.MULTIPLICACION);}
{WHITE}* "+" {return symbolo(sym.SUMA);}
{WHITE}* "-" {return symbolo(sym.RESTA);}
{WHITE}* "/" {return symbolo(sym.DIVISION);}
{WHITE}* "**" {return symbolo(sym.EXPONENCIACION);}

//operadores relacionales
{WHITE}*"^" {return symbolo(sym.POTENCIA);}
{WHITE}*"<" {return symbolo(sym.MENORQUE);}
{WHITE}*">" {return symbolo(sym.MAYORQUE);}
{WHITE}*"<=" {return symbolo(sym.MENORIGUAL);}
{WHITE}*">=" {return symbolo(sym.MAYORIGUAL);}
{WHITE}* "!=" {return symbolo(sym.DISTINTO);}
{WHITE}* "==" {return symbolo(sym.IGUALDAD);}


{WHITE} {/*IGNORE*/}



<<EOF>> {return symbolo(sym.EOF);}


