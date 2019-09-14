/*
Thomas Sanchez
Lecture 7

Sept 6, 2018
*/
class lecture7{
   public static void main(String[] args){
   String S = "hello";
   
   System.out.println(S);
   System.out.println(S.substring(3,5));
   System.out.println(S.replace("llo", "y how are you "));
   System.out.println(S.length());
   System.out.println(S.charAt(S.length() - 1));// give final letter in string
   System.out.println(S.toUpperCase());
   System.out.println(S);
   System.out.println(S.indexOf('e'));// letter not there results in -1
   }// of main



}