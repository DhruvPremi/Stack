package com.datastruct.stack;

import java.util.Iterator;

public class StackByLinkList<Item> implements Iterable<Item> 
{
	// Make it Iterable
	LinkList head = null;
	
	private class LinkList
	{
		Item item;
		LinkList next;
	}
	
	public void push(Item item1)
	{
		LinkList temp = new LinkList();
		temp.item = item1;
		temp.next = head;
		head = temp;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public Item pop()
	{
		if(isEmpty()) 
		{
			return null;
		}
		Item toRet = head.item;
		head = head.next;
		return toRet;
	}

	@Override
	public Iterator<Item> iterator() 
	{
		// TODO Auto-generated method stub
		return new LinkListIterator();
	}
	
	private class LinkListIterator implements Iterator<Item>
	{
		
		LinkList current = head;
		
		@Override
		public boolean hasNext() 
		{
			return current != null;
		}

		@Override
		public Item next() 
		{
			Item iTemp  = current.item;
			current = current.next;
			return iTemp;
		}
	}
	
}
