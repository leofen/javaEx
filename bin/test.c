/*
 * =====================================================================================
 *
 *       Filename:  test.c
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  2013/09/15 22时29分02秒
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  YOUR NAME (), 
 *   Organization:  
 *
 * =====================================================================================
 */

#include	<stdlib.h>
#include    <stdio.h>

struct shell {
    int sum[10];
};

/* 
 * ===  FUNCTION  ======================================================================
 *         Name:  main
 *  Description:  
 * =====================================================================================
 */
    int
main ( int argc, char *argv[] )
{
    struct shell a;
    int i = 0;
    for(i = 0; i < 10; i++)
        a.sum[i] = i;
    struct shell b = a;
    for(i = 0; i < 10; i++)
        printf("%d\n",b.sum[i]);
    return EXIT_SUCCESS;
}				/* ----------  end of function main  ---------- */
