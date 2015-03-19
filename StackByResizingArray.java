package com.datastruct.stack;

import java.util.Iterator;

public class StackByResizingArray<Item> implements Iterable<Item> 
{
	Item[] array;
	
	int N = 0;
	int max = 0;
	
	StackByResizingArray()
	{
		max = 1;
		array = (Item[]) new Object[1];
	}
	
	public boolean isEmpty()
	{
		return ((N == 0));
	}
	
	public boolean isFull()
	{
		return ((N == max));
	}
	
	public void push(Item item)
	{
		if(isFull())
		{
			resizeArray();
			System.out.println("Already filled up Dude");
		}
		
		array[N++] = item;
		
	}
	
	public void resizeArray()
	{
		if(N == max)
		{
			Item[] temp = (Item[]) new Object[2*max];
			
			System.out.println("Increasing the Size of the Array");
			
			for(int i =0 ; i < N ; i++)
			{
				temp[i] = array[i];
			}
			
			array = temp;
			max = 2*max;
		}
		else
		{
			Item[] temp = (Item[]) new Object[max/2];
			
			System.out.println("Decreasing the Size of the Array");
			
			for(int i =0 ; i < N ; i++)
			{
				temp[i] = array[i];
			}
			
			array = temp;
			max = max/2;
			
		}
	}
	
	public Item pop()
	{
		
		if(isEmpty())
		{
			return null;
		}
		
		if(max > 4*N)
		{
			resizeArray();
		}
		return array[--N];
	}
	
	@Override
	public Iterator<Item> iterator() 
	{
		// TODO Auto-generated method stub
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item>
	{
		int current = N;
		
		@Override
		public boolean hasNext() 
		{
			// TODO Auto-generated method stub
			return (current != 0);
		}

		@Override
		public Item next() 
		{
			// TODO Auto-generated method stub
			return array[--current];
		}
	}
	
	
}
