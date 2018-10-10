// Code your testbench here
// or browse Examples
`timescale 1 ns / 1 ns
module firstFSMTest ;
  
  //Sequencia a ser detectada
  reg [3:0] in = 4'b0010;

  //Sinais
  reg clock, reset;
  reg sequence;
  wire flag; //Flag que nos dirá se a sequencia foi encontrada

  //Inicializando registradores em 0
  initial
  begin
    clock = 1'b0 ;
    sequence = 1'b0;
  end

  //Inicializando reset em 1 e com atraso de 30 para 0
  initial     
  begin
    reset = 1'b1 ;
    #30 reset = 1'b0 ;
  end

  //Entrada serial dada a cada subida do clock 
  initial
  begin
    @(posedge clock);
    @(posedge clock);     sequence <= 1'b1 ; 
    @(posedge clock);     sequence <= 1'b0 ; 
    @(posedge clock);     sequence <= 1'b0 ; 
    @(posedge clock);     sequence <= 1'b1 ; 
    @(posedge clock);     sequence <= 1'b0 ; 
    @(posedge clock);     sequence <= 1'b1 ; 
    @(posedge clock);     sequence <= 1'b1 ; 
    @(posedge clock);     sequence <= 1'b0 ; 
    @(posedge clock);     sequence <= 1'b1 ; 
    @(posedge clock);

  $finish;

  end


  //Inicializando a nossa máquina
  detector machine ( 
     .clock(clock),
     .reset(reset),
     .in(in),
     .sequence(sequence),
      .flag(flag));

  always #11 clock = ~clock; 
  always #22 $display(flag);
        
endmodule 