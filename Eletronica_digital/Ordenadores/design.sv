// Code your design here
module comparator8bits(
  input [7:0] a, b,
  output major);
 
  wire [7:0] f, x;
  wire maj;
  xnor(f[0], ~a[0], ~b[0]);
  xnor(f[1], ~a[1], ~b[1]);
  xnor(f[2], ~a[2], ~b[2]);
  xnor(f[3], ~a[3], ~b[3]);
  xnor(f[4], ~a[4], ~b[4]);
  xnor(f[5], ~a[5], ~b[5]);
  xnor(f[6], ~a[6], ~b[6]);
  xnor(f[7], ~a[7], ~b[7]);
  
  and(x[0], f[7], f[6], f[5], f[4], f[3], f[2], f[1], a[0], ~b[0]);
  and(x[1], f[7], f[6], f[5], f[4], f[3], f[2], a[1], ~b[1]);
  and(x[2], f[7], f[6], f[5], f[4], f[3], a[2], ~b[2]);
  and(x[3], f[7], f[6], f[5], f[4], a[3], ~b[3]);
  and(x[4], f[7], f[6], f[5], a[4], ~b[4]);
  and(x[5], f[7], f[6], a[5], ~b[5]);
  and(x[6], f[7], a[6], ~b[6]);
  and(x[7], a[7], ~b[7]);

  or(maj, x[7], x[6], x[5], x[4], x[3], x[2], x[1], x[0]);
  assign major = maj;
  
endmodule

module greaterLower(
  
  input [7:0] x, y,
  input major,
  output [7:0] lower, greater);
  
  wire m = ~major;
  assign greater = x * major + y * m;
  assign lower = x * m + y * major;

endmodule

module compare(
  input [7:0] input1, input2,
  output [7:0] max, min);
  
  wire major;
  
  comparator8bits c(
    .a(input1),
    .b(input2),
    .major(major));
  
  wire [7:0] mi, mx;
  
  greaterLower mm(
    .x(input1),
    .y(input2),
    .major(major),
    .lower(mi),
    .greater(mx));
  
  assign max = mx;
  assign min = mi;
  
endmodule

module sort(
  input [7:0] n1, n2, n3, n4, n5, n6, n7, n8,
  output [7:0] first, second, third, fourth, fifth, sixth, seventh, eighth);
  
  wire [7:0] a1, a2, a3, a4, a5, a6, a7, a8;  
  
  compare cc1(
    .input1(n1),
    .input2(n2),
    .max(a1),
    .min(a2));
  
  compare cc2(
    .input1(n3),
    .input2(n4),
    .max(a3),
    .min(a4));

  compare cc3(
    .input1(n5),
    .input2(n6),
    .max(a5),
    .min(a6));
  
  compare cc4(
    .input1(n7),
    .input2(n8),
    .max(a7),
    .min(a8));
  
  wire [7:0] b1, b2, b3, b4, b5, b6, b7, b8;
  
  compare cc5(
    .input1(a1),
    .input2(a3),
    .max(b1),
    .min(b2));
  
  compare cc6(
    .input1(a2),
    .input2(a4),
    .max(b3),
    .min(b4));
  
  compare cc7(
    .input1(a5),
    .input2(a7),
    .max(b5),
    .min(b6));
  
  compare cc8(
    .input1(a8),
    .input2(a6),
    .max(b7),
    .min(b8));
 
  wire [7:0] c1, c2, c3, c4;
  
  compare cc9(
    .input1(b2),
    .input2(b3),
    .max(c1),
    .min(c2));
  
  compare cc10(
    .input1(b6),
    .input2(b7),
    .max(c3),
    .min(c4));

  wire [7:0] d1, d2, d3, d4, d5, d6, d7, d8;
  
  compare cc11(
    .input1(b1),
    .input2(b5),
    .max(d1),
    .min(d2));
  
  compare cc12(
    .input1(c1),
    .input2(c3),
    .max(d3),
    .min(d4));
  
  compare cc13(
    .input1(c2),
    .input2(c4),
    .max(d5),
    .min(d6));

  compare cc14(
    .input1(b4),
    .input2(b8),
    .max(d7),
    .min(d8));

  wire [7:0] e1, e2, e3, e4, e5, e6;
  
  compare cc15(
    .input1(d2),
    .input2(d3),
    .max(e1),
    .min(e2));

  compare cc16(
    .input1(d4),
    .input2(d5),
    .max(e3),
    .min(e4));
  
  compare cc17(
    .input1(d6),
    .input2(d7),
    .max(e5),
    .min(e6));
  
  wire [7:0] f1, f2, f3, f4;
  
  compare cc18(
    .input1(e2),
    .input2(e3),
    .max(f1),
    .min(f2));
  
  compare cc19(
    .input1(e4),
    .input2(e5),
    .max(f3),
    .min(f4));
  
  wire [7:0] g1, g2;
  
  compare cc20(
    .input1(f2),
    .input2(f3),
    .max(g1),
    .min(g2));
  
  assign first = d1;
  assign second = e1;
  assign third = f1;
  assign fourth = g1;
  assign fifth = g2;
  assign sixth = f4;
  assign seventh = e6;
  assign eighth = d8;
  
  
endmodule
