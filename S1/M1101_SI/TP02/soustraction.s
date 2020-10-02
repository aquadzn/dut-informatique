    .data
var1:   .short 7
var2:   .short 4
var3:   .short 0
        .text
        .global main
main:
    mov var1, %ax
    movl var2, %ebx
    subl %ebx, %ax
    mov %ax, var3
    ret
