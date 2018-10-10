// Code your testbench here
// or browse Examples
// Code your testbench here
// or browse Examples
module test;
  
 
  reg [7:0] a, b, c, d, e, f, g, h;
  wire [7:0] i, j, k, l, m, n, o, p;
  sort s(
    .n1(a), .n2(b), .n3(c), .n4(d),
    .n5(e), .n6(f), .n7(g), .n8(h),
    .first(i), .second(j), .third(k), .fourth(l),
    .fifth(m), .sixth(n), .seventh(o), .eighth(p));
  
  initial begin
    a = 5;  b = 12;  c = 255;  d = 1;
    e = 0;  f = 12;  g = 19; h = 68;
    #1
    $display(i, j, k, l, m, n, o, p);

  end
  
endmodule