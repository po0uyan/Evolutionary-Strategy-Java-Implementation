# Evolutionary_Strategy
An implementation of Evolutionary Algorythm, in pure java,
This project icludes:
1. faster offspring evaluation, by implementing simultaneously evaluation.
2. user friendly interface provided to adjust algorythm settings as easy as possible.
3. innovative inline and realtime cost function compilation, which is possible to provide as a java code in application iterface. 
4. preconfigured and written famouse objective functions, which is selectable within the application ui. 

inorder to start the application just run the main class inside your ide. if everything goes well, you should see the following:


![Screenshot from 2021-11-02 10-30-08](https://user-images.githubusercontent.com/19612313/139800694-33edaaca-2a79-4704-b57f-0035eb65aa86.png)

* as you can see you can choose from multiple fittness functions which are available by default. by choosing a fitness function, corresponding function java code will be loaded into your code section window, you can change it as you want, or just write your own. 

* settings such as permutation probability and crossover probabilty also could be set befor starting the process.

![Screenshot from 2021-11-02 10-31-23](https://user-images.githubusercontent.com/19612313/139800724-1f5f0c1f-eafb-4641-8be7-b7c370d35415.png)

* after selecting each of our predefined fitness functions, you can see a message which gives you important information about this function optimum points and modality, it also tells us what are the best choises for our interval constraints.

![Screenshot from 2021-11-02 10-32-15](https://user-images.githubusercontent.com/19612313/139800748-2e3cd791-1fa3-4eec-82b6-8b6f6aff87fc.png)

* after loading or writing your own fitness function, it would be the time to start!. 
* remember that this implementation leverages thread pools to offer simultaneouse offspring evaluation, and off course! , performance. 

**this project is developed for academic purposes**
