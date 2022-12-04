package com.joel.problemsolving.round1.problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void enqueue_동물을_들여보낼_수_있다() throws Exception {
        Problem2 sut = new Problem2();
        sut.enqueue(new Dog());
        sut.enqueue(new Cat());
        sut.enqueue(new Dog());
        sut.enqueue(new Cat());


        assertEquals(4, sut.getNumberOfAnimals());
    }

    @Test
    void dequeueAny_먼저_들어온_순서대로_동물을_리턴한다() throws Exception {
        Problem2 sut = new Problem2();
        sut.enqueue(new Dog());
        sut.enqueue(new Cat());
        sut.enqueue(new Dog());
        sut.enqueue(new Cat());


        assertInstanceOf(Dog.class, sut.dequeueAny());
        assertInstanceOf(Cat.class, sut.dequeueAny());
        assertInstanceOf(Dog.class, sut.dequeueAny());
        assertInstanceOf(Cat.class, sut.dequeueAny());
        assertEquals(0, sut.getNumberOfAnimals());
    }

    @Test
    void dequeueAny_동물이_없는_경우에는_null을_리턴한다() {
        Problem2 sut = new Problem2();


        assertNull(sut.dequeueAny());
    }

    @Test
    void dequeueCat_고양이들_중에서_가장_먼저_들어온_고양이가_리턴된다() throws Exception {
        Problem2 sut = new Problem2();
        sut.enqueue(new Dog());
        sut.enqueue(new Cat());
        sut.enqueue(new Dog());
        sut.enqueue(new Cat());


        Cat cat = sut.dequeueCat();
        assertEquals(1, cat.getOrder());
        assertEquals(3, sut.getNumberOfAnimals());
    }

    @Test
    void dequeueCat_고양이가_없는_경우에는_null을_리턴한다() throws Exception {
        Problem2 sut = new Problem2();
        sut.enqueue(new Dog());
        sut.enqueue(new Dog());


        assertNull(sut.dequeueCat());
    }

    @Test
    void dequeueDog_개들_중에서_가장_먼저_들어온_개가_리턴된다() throws Exception {
        Problem2 sut = new Problem2();
        sut.enqueue(new Cat());
        sut.enqueue(new Dog());
        sut.enqueue(new Cat());
        sut.enqueue(new Dog());


        Dog dog = sut.dequeueDog();
        assertEquals(1, dog.getOrder());
        assertEquals(3, sut.getNumberOfAnimals());
    }

    @Test
    void dequeueDog_개가_없는_경우에는_null을_리턴한다() throws Exception {
        Problem2 sut = new Problem2();
        sut.enqueue(new Cat());
        sut.enqueue(new Cat());


        assertNull(sut.dequeueDog());
    }
}