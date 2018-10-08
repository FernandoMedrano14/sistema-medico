public class pruebaString {
    public static void main(String[] args) {
   String nombre="Yohalmo";
   String nombre2 = "Yohalmo2";
   String letras =nombre.substring(0,4);
   String letras2 = nombre2.substring(0,4);
        System.out.println(nombre.compareTo(nombre2));
   
   if(letras.equals(letras2)){
       System.out.println("Son iguales");
   }else{
       System.out.println("Son diferentes");
   }
}
}
