/*Para identificarmos a sequencia, usaremos uma Máquina De Mealy*/


module detector(
  input wire clock,
  input wire reset,
  input [3:0] in,
  input wire sequence,
  output reg flag);

//Estados
localparam A = 2'b00 ;
localparam B = 2'b01 ;
localparam C = 2'b10 ;
localparam D = 2'b11 ;

//Sinais
reg [1:0] presentState ;
reg [1:0] nextState ;

//Controle de estados
always @ (posedge clock , posedge reset )
begin
  if(reset)     presentState <= A;
  else if (clock)   presentState <= nextState;
end

always @ *
begin
  nextState = presentState;
  flag = 1'b0;

  case(presentState)
    A: if (sequence == in[3])   nextState = B ;
    B: 
          begin
            if (sequence == in[2])   nextState = C ;
            else        nextState = A ;
          end
    C: if (sequence == in[1])  nextState = D ;
    D: 
          begin
            if(sequence == in[0])
                begin
                  flag = 1'b1 ;
                  nextState = A;
                end
            else    nextState = A;
          end
      default:               
              begin
                flag = 1'b0 ;
                nextState = A ;
              end
	endcase
end
endmodule
