int x;

void main(void)
begin
  int y,z,a;
  
  x = 3 + 1;
  write x; write "\n";
  y = x - 6;
  write y; write "\n";
  z = y / 2;
  write z; write "\n";
  x = z * 13;
  write x; write "\n";
  
  a = 12;
  
  if (a <= 4) then write "a<=4 wrong(1)\n";
  if (a <= 12) then write "a<=1 good(1)\n";
  if (a <= 24) then write "a<=24 good(2)\n";
  
  if (a == 1) then write "a==-1 wrong(2)\n";
  if (a == 12) then write "a==1 good(3)\n";
  
  if (a >= 5) then write "a>=5 good(4)\n";
  if (a >= 12) then write "a>=12 good(5)\n";
  if (a >= 32)then write "a>=32 wrong(3)\n";
  
  if (a != 89) then write "a!=89 good(6)\n";
  if (a != 12) then write "a!=12 wrong(4)\n";
  
  if (a < 2) then write "a<2 wrong(5)\n";
  if (a < 12) then write "a<12 wrong(6)\n";
  if (a < 48) then write "a<48 good(7)\n";
  
  if (a > 2) then write "a>2 good(8)\n";
  if (a > 12) then write"a>12 wrong(7)\n";
  if (a > 51) then write "a>51 wrong(8)\n";
  
  write "8 good statements 8 wrong";
end
  
  
