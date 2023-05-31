.model small

.stack 100h
 
 .data
 
 

.Model Small
    .Stack 100h
        .Data
          Greating DB                     "~~~~~~~~~ Hello welcome to our Health conference Ticket Application ~~~~~~~~~$"
 Menu     DB 0AH,0DH, "          ****************************************************** ",0AH,0DH, "          *       The Ticket         *         | Price         * ",0AH,0DH, "          ****************************************************** ",0AH,0DH, "          *  1-Medical Student       *          300 RS         * ",0AH,0DH, "          *  2-Resident Doctor       *          500 RS         * ",0AH,0DH, "          *    3-Specialist Doctor     *          1300 RS        * ",0AH,0DH, "          ******************************************************$"
 Choose   DB 0AH,0DH,0AH,0DH,">>>>> Enter a Number shown in Menu to select a ticket: $"
 TicketNo   DB 0AH,0DH,        ">>>>> Enter amount of tickets wanted: $"
 AnoTic   DB 0AH,0DH,        ">>>>> If you'd like Another ticket please enter '1' Else Enter '0' : $"
 SpeakerMsg   DB 0AH,0DH,        ">>>>> If you are a speaker at the conference please enter '1' if not enter '0': $"
 TotPri   DB 0AH,0DH,        ">>>>> The total price: $"
 PriDis   DB 0AH,0DH,        ">>>>> The total price after discount: $"
 total dw 0
 discount  dw 50    
       


 
 choice1 db 0dh,0ah,0dh,0ah, ' 1. Book a Ticket $'
 choice2 db 0dh,0ah, ' 2. Calculate The Price $'
 choice3 db 0dh,0ah, ' 3. Exit The Application $'
 selection db 0dh,0ah,0dh,0ah, '>> Enter a number shown in Menu to select a ticket: $'
 tottic db 0dh,0ah,0dh,0ah, '>> Enter how many tickets would you like to buy: $' ,0dh,0ah
 return db 0dh,0ah,0dh,0ah, 'Press any key to return menu: $'

  greetings db                     "~~~~~~~~~  Welcome to our health conference ticket application ~~~~~~~~~$" 
 menu     db 0ah,0dh, "          ****************************************************** ",0ah,0dh, "          *       the ticket         *         | price         * ",0ah,0dh, "          ****************************************************** ",0ah,0dh, "          *  1-medical student       *          300 rs         * ",0ah,0dh, "          *  2-resident doctor       *          500 rs         * ",0ah,0dh, "          *  3-specialist doctor     *          1300 rs        * ",0ah,0dh, "          ******************************************************$"
 
 result db 0dh,0ah,0dh,0ah, 'Total price... $'
 discount db 0dh,0ah,0dh,0ah, ' yay! you have a discounts 1/2 off...$'
 msg_disc_code db 0dh,0ah,0dh,0ah, 'If you are a speaker at the conference please enter '1' if not enter '0':$'
 
 
 
 sum dw 0

 d50 dw 50
 d100 dw 100

 
 .code
 
 main proc
 
 ;initialize data segment.
 mov ax, @data
 mov ds, ax
 
 start:
 ;clear screen
 mov ah, 0 ; setting a graphics mode through bios (int 10h with ah=0) will 
;clear the screen
 mov al, 3
 int 10h
 
 lea dx, greetings ; load and print msg_0
 mov ah,9
 int 21h
 
 
 lea dx, choice1 ; load and print msg_1
 mov ah,9
 int 21h
 
 lea dx, choice2 ; load and print msg_2
 mov ah,9
 int 21h
 
 lea dx, choice3 ; load and print msg_3
 mov ah,9
 int 21h
 
 
 
 lea dx, selection ; load and print msg_4
 mov ah,9
 int 21h
 
 
 mov ah , 1 ; read a first choice
 int 21h
 
 cmp al,"1" ; 31 h 
 je ticketdata
 cmp al,"2"
 je disp_invoice
 cmp al,"3"
 je exit
 
 jmp start
 
 ticketdata:
 ;clear window
 mov ah, 0
 mov al, 3
 int 10h
 
 lea dx, menu
 mov ah, 9
 int 21h
 
 or_loop:
 
 mov bx,0
 
 
 lea dx, selection ; load and print tottic
 mov ah,9
 int 21h
 
 mov ah , 1 ; read a first choice
 int 21h
 
 cmp al,"0"
 je start
 cmp al,"1" ; 31 h 
 je p300a
 cmp al,"2"
 je p500a
 cmp al,"3"
 je p1300a
    
 CMP AL,"3"
 JG ticketdata 
 
 p300a:
 mov bx,300
 jmp en
 p500a:
 mov bx,500
 jmp en
 
 p1300a:
 mov bx,1300
 jmp en
 
 en:
 
 
 lea dx, tottic ; load and print tottic
 mov ah,9
 int 21h
 
 call indec ;ax 
 mul bx ;200
 
 add sum,ax
 
 
 jmp or_loop  
 
 
 disp_invoice:
 
 mov ah, 0
 mov al, 3
 int 10h
 
 lea dx, result ; load and print tottic
 mov ah,9
 int 21h
 
 mov ax, sum
 call outdec
 
 lea dx, msg_disc_code ; load and print msg_disc_code
 mov ah,9
 int 21h
 
 
 
 mov ah , 1 ; read a first choice
 int 21h
 
 cmp al,"1"
 jne disp
 
 lea dx, discount ; load and print msg_0
 mov ah,9
 int 21h
 
 mov ax,sum
 mul d50
 div d100 ; 200 * 30/100 =60
 
 sub sum, ax ;200-60=140
 
 disp:
 
 lea dx, result ; load and print msg_5
 mov ah,9
 int 21h
 
 mov ax, sum
 call outdec
 
 mov ah , 1 ; read a first choice
 int 21h
 
 
 jmp start
 
 exit:
 
 mov ah, 4ch ; return control to dos
 int 21h
 
 
 
 main endp  

            
            ;include outdec.asm            
            indec	proc
                push	bx
                push	cx
                push	dx
                
                @begin:
                xor	bx,bx
                xor	cx,cx
                
                mov	ah,1
                int	21h
                cmp	al,'-'
                je	@minus
                cmp	al,'+'
                je	@plus	
                jmp	@repeat2
                @minus:
                mov	cx,1
                @plus:
                int	21h
                @repeat2:
                cmp	al,'0'
                jnge	@not_digit
                cmp	al,'9'
                jnle	@not_digit
                and	ax,000fh
                push	ax
                mov	ax,10
                mul	bx
                pop	bx
                add	bx,ax
                mov	ah,1
                int	21h
                cmp	al,0dh
                jne	@repeat2
                mov	ax,bx
                or	cx,cx
                je	@exit
                neg	ax
                @exit:
                pop	dx
                pop	cx
                pop	bx
                ret
                @not_digit:
                mov	ah,2
                mov	dl,0dh
                int	21h
                mov	dl,0ah
                int	21h
                jmp	@begin
            indec	endp


            ;include outdec.asm
            outdec	proc
                push	ax
                push	bx
                push	cx
                push	dx
                or	ax,ax
                jge	@end_if1
                push	ax
                mov	dl,'-'
                mov	ah,2
                int	21h
                pop	ax
                neg	ax
                @end_if1:
                xor	cx,cx
                mov	bx,10d
                @repeat1:
                xor	dx,dx
                div	bx
                push	dx
                inc	cx
                or	ax,ax
                jne	@repeat1
                mov	ah,2
                @print_loop:
                pop	dx
                or	dl,30h
                int	21h
                loop	@print_loop
                pop	dx
                pop	cx
                pop	bx
                pop	ax
                ret
            outdec	endp


            
 
 
 
 end main