package com.joel.problemsolving.round1.problem2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 먼저 들어온 동물이 먼저 나가는 동물쉼터(animal shelter)가 있다고 하자.
 * 이 쉼터는 개와 고양이만 수용할 수 있다.
 * 사람들은 쉼터의 동물들 가운데 들어온 지 가장 오래된 동물부터 입양할 수 있는데, 개와 고양이 중에 어떤 동물을 데려갈지 선택할 수 있다.
 * 개들 중에 혹은 고양이들 중에 특정 동물을 지정해서 데려가는 것은 금지되어 있다.
 * 이 시스템을 자료구조로 구현하라. 해당 자료구조는 enqueue(), dequeueAny(), dequeueDog(), dequeueCat() 연산을 제공해야 한다.
 */
public class Problem2 {

    private int numberOfAnimals;
    private Queue<Dog> dogs;
    private Queue<Cat> cats;

    public Problem2() {
        this.numberOfAnimals = 0;
        this.dogs = new ConcurrentLinkedQueue<>();
        this.cats = new ConcurrentLinkedQueue<>();
    }

    public synchronized void enqueue(Animal animal) throws Exception {
        if(animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.setOrder(this.numberOfAnimals);
            dogs.offer(dog);
        } else if(animal instanceof Cat){
            Cat cat = (Cat) animal;
            cat.setOrder(this.numberOfAnimals);
            cats.offer(cat);
        } else {
            throw new Exception("개도 아니고 고양이도 아닙니다.");
        }
        this.numberOfAnimals++;
    }

    public synchronized Animal dequeueAny() {
        if(this.numberOfAnimals == 0) return null;
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        this.numberOfAnimals--;
        if(dog == null && cat != null) {
            return cats.poll();
        } else if(dog != null && cat == null) {
            return dogs.poll();
        } else if(dog.getOrder() < cat.getOrder()) {
            return dogs.poll();
        } else {
            return cats.poll();
        }
    }

    public synchronized Dog dequeueDog() {
        this.numberOfAnimals--;
        return dogs.poll();
    }

    public synchronized Cat dequeueCat() {
        this.numberOfAnimals--;
        return cats.poll();
    }

    public int getNumberOfAnimals() {
        return this.numberOfAnimals;
    }
}
