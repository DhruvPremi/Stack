package com.datastruct.stack;

import java.util.Iterator;

public class StackByArray<Item> implements Iterable<Item>
{
	Item[] array;
	int N = 0;
	int max;
	
	StackByArray(int n)
	{
		max = n;
		array = (Item[]) new Object[n];
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
			System.out.println("Already filled up Dude");
			return ;
		}
		array[N++] = item;
	}
	
	public Item pop()
	{
		if(isEmpty())
		{
			return null;
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
