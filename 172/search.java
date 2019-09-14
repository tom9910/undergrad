class search{

   static int findit(int A1[], int e){
   
      int u, l;
      int m;
      u = A1.length;
      l = 0;
      
      m = (u + 1)/ 2;
      
      while(m != u && m != 1){
      
         if(A1[m] == e) return m;
         else
            if(A1[m] > e)
               u = (m - 1);
            else l = (m + 1);
            
           m = (u + 1)/2;
      
      }
   
   if (A1[m] == e) return m;
      else return - 1;
   
   }// of find it

}