//lecture 28_1 
//write a class

class computer{
      
      String Vendor;
      
      int modelno;
      
      int memory;
      
      int disk;
      
      public computer(String v, int model, int Memory, int Disk){
      
         setVendor(v);
         setModelno(model);
         setmemory(Memory);
         setDisk(Disk);
      
      }
     
     public void setVendor(String S){
      Vendor = S;
     }// of set vendor
     
     public void setModelno(int m){
     if (m > 0) modelno = m;
     else m = 0;
     
     }
     public void setmemory(int M){
     if(M > 0) memory = M;
     else memory = 0;
     }
     
     public void setDisk(int D){
     disk = D;
     }
     
     
     public String toString(){
     
      return String.format("Computer %s model %d memory %dGB disk %dTB",Vendor, modelno, memory, disk);
     
     } 
      

}