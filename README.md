# Practicing Java

This repository contains Java implementations of Two computer science problems including **Concurrency** (Dining Philosophers Problem) and **Data Structures** (LRU Cache).

---

### 1. Dining Philosophers Problem 

A simulation of the **Dining Philosophers problem**, a classic synchronization challenge demonstrating **deadlock prevention** and **resource sharing** among concurrent threads.

####  Implementation
- Each philosopher runs as a separate `Thread`.
- `Fork` objects represent shared locks.
- Uses careful fork-picking order (the last philosopher picks forks in reverse) to prevent circular wait.

### 2. LRU Cache

An efficient **Least Recently Used (LRU) Cache** implementation in Java, designed to perform all operations in **O(1)** time using a combination of **HashMap** and **Doubly Linked List**.

####  Implementation

- Combines a **`HashMap<Integer, Node>`** for fast key lookups with a **doubly linked list** for usage ordering.  
- The **head** and **tail** are dummy nodes to simplify insertion and removal logic.  
- Every time an item is accessed or updated, it’s moved to the **front** (MRU position).  
- When capacity is full, the **last node (LRU)** is removed in **O(1)** time.  
