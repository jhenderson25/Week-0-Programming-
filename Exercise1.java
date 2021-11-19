
package com.mycompany.programmingexercise1;

/*
Week 0 Programming Project
CSC144 Object-Oriented Programming
Jake Henderson
November 19, 2021

I worked with Harper on one piece of code.
I borrowed and modified code from Leon Tabak.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exercise1 {

    public static List<Integer> makeList( int size, Random rng ) {
        List<Integer> result = new ArrayList<>();
        
        for( int i = 0; i < size; i++ ) {
            result.add( rng.nextInt( 200 ) );
        } //for
        
        return result;
    } //makeList( int, Random )
    
    public static void printList( List<Integer> info ) {
        for( int nums : info ) {
            System.out.println( nums );
        } // for
    } // printList( List<Integer> )
    
    public static int posSmallestInt( List<Integer> info, int start ) {
        int guessRightNow = start;
        
        for( int i = start + 1; i < info.size(); i++ ) {
            if( info.get(i) < info.get(guessRightNow) ) {
                guessRightNow = i;
            } // if
        } // for
        
        return guessRightNow;
    } // posSmallestInt( List<Integer>, int )
    
    public static int smallestInt( List<Integer> info, int start ) {
        int smallestRightNow = info.get(start);
        
        for( int i = start + 1; i < info.size(); i++ ) {
            if( info.get(i) < smallestRightNow ) {
                smallestRightNow = info.get(i);
            } // if
        } // for
        
        return smallestRightNow;
    } //smallestInt( List<Integer> )
    
    public static void exchange( List<Integer> info, int x, int y) {
        int temp = info.get(x);
        info.set( x, info.get(y) );
        info.set( y, temp);
    } // exchange( List<Integer>, int, int )
    
    public static void selection( List<Integer> info ) {
        for( int i = 0; i < info.size(); i++ ) {
            int x = posSmallestInt( info, i );
            exchange( info, i, x);
        } // for
    } // selection( List<Integer> )
    
    public static void insertion( List<Integer> info, int start ) {
        int i = start;
        while(i > 0 && info.get(i) < info.get(i - 1)) {
            exchange(info, i, i - 1);
            i--;
        } // while
    } // insertion( List<Integer> )
    
    public static List<Integer> merge( List<Integer> data, List<Integer> info ) {
        List<Integer> comb = new ArrayList<>();
        
        int a = 0;
        int b = 0;
        
        while(a < data.size() && b < info.size()) {
            if(data.get(a) < info.get(b)) {
                comb.add(data.get(a));
                a++;
            } // if
            else {
                comb.add(info.get(b));
                b++;
            } // else
        } // while
        
        while(a < data.size()) { 
            comb.add(data.get(a));
            a++;
        } // while
        
        while(b < info.size()) {
            comb.add(info.get(b));
            b++;
        } // while
        
        return comb;
    } // merge( List<Integer> )
    
    public static void main(String[] args) {
        
       Random rng = new Random();
       List<Integer> numbers = makeList( 12, rng );
       printList( numbers );
       
       System.out.println();
       
       int index = posSmallestInt( numbers, 0 );
       System.out.println( "index = " + index );
       System.out.println();
       int small = smallestInt( numbers, 0 );
       System.out.println( "smallest value = " + small );
       System.out.println();
       
       exchange( numbers, 4, 5 );
       System.out.println("Exchange of indexes 4 and 5");
       printList( numbers );
       
       System.out.println();
       System.out.println("Selection sort");
       selection( numbers );
       printList( numbers );
       
       List<Integer> partlySorted = new ArrayList<>();
       partlySorted.add( 1 );
       partlySorted.add( 30 );
       partlySorted.add( 42 );
       partlySorted.add( 12 );
       partlySorted.add( 36 );
       partlySorted.add( 4 );
       
       System.out.println( "\nFirst 3 elements in order.\n");
       printList( partlySorted );
       
       insertion( partlySorted, 3 );
       
       System.out.println("\nFirst 4 elements in order.\n");
       printList( partlySorted );
       
       insertion( partlySorted, 4 );
       
       System.out.println("\nFirst 5 elements in order.\n");
       printList( partlySorted );
       
       insertion( partlySorted, 5 );
       
       System.out.println("\nFirst 6 elements in order.\n");
       printList( partlySorted );
       
       List<Integer> data = makeList(6, rng);
       selection(data);
       List<Integer> info = makeList(6, rng);
       selection(info);
       
       List<Integer> comb = merge(data, info);
       
       System.out.println("\nA short sorted list.\n");
       printList(data);
       System.out.println("\nAnother short sorted list.\n");
       printList(info);
       System.out.println("\nA merger of the two short sorted lists.\n");
       printList(comb);
       
    } //main( String [] )
      
} // Exercise

