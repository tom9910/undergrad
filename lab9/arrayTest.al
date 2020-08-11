int A[100];
void main(void) begin
  int x[5];
  int i;
  int y;
   i=0;
  while i < 5 do
   begin
      write "enter X: ";
      read x[i];
      i = i + 1;
   end
 
   i=0;

  while (i < 5) do
   begin
      write x[i] * x[i];
      write "\n";
      i = i + 1;
   end
   
   y = 10;
   while y >= 0 do
    begin
      A[y] = y;
      write "A[";
      write y;
      write "] = ";
      write A[y];
      write "\n";
      y = y - 1;
    end
end
