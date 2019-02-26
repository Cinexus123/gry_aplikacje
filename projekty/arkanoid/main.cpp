#include <SFML/Graphics.hpp>
#include <time.h>
using namespace sf;
int main()
{
    Texture t1,t2,t3,t4,t5,t6,t7,t8;
    t1.loadFromFile("images/block01.png");
    t2.loadFromFile("images/arka.png");
    t3.loadFromFile("images/pilka.png");
    t4.loadFromFile("images/paddle.png");
    t5.loadFromFile("images/block02.png");
    t6.loadFromFile("images/block03.png");
    t7.loadFromFile("images/block04.png");
    t8.loadFromFile("images/block05.png");
    srand(time(NULL));
    RenderWindow app(VideoMode(500, 450), "Zagrajmy w gre! :)");
    app.setFramerateLimit(60);
    Sprite sBackground(t2), sBall(t3), sPaddle(t4);
    sPaddle.setPosition(300,440);

    Sprite block[1000];

    int n=0;
    for (int i=1;i<=10;i++)
    for (int j=1;j<=2;j++)
      {
         block[n].setTexture(t1);
         block[n].setPosition(i*43,j*20);
         n++;
      }
       for (int i=1;i<=10;i++)
    for (int j=3;j<=4;j++)
      {
         block[n].setTexture(t5);
         block[n].setPosition(i*43,j*20);
         n++;
      }
           for (int i=1;i<=10;i++)
    for (int j=5;j<=6;j++)
      {
         block[n].setTexture(t6);
         block[n].setPosition(i*43,j*20);
         n++;
      }
           for (int i=1;i<=10;i++)
    for (int j=7;j<=8;j++)
      {
         block[n].setTexture(t7);
         block[n].setPosition(i*43,j*20);
         n++;
      }
           for (int i=1;i<=10;i++)
    for (int j=9;j<=10;j++)
      {
         block[n].setTexture(t8);
         block[n].setPosition(i*43,j*20);
         n++;
      }

    float dx=6, dy=5;
	float x=300, y=300;

    while (app.isOpen())
    {
       Event e;
       while (app.pollEvent(e))
       {
         if (e.type == Event::Closed)
             app.close();
       }

    x+=dx;
    for (int i=0;i<n;i++)
		if ( FloatRect(x+3,y+3,6,6).intersects(block[i].getGlobalBounds()) )
		     {block[i].setPosition(-100,0); dx=-dx;}

    y+=dy;
    for (int i=0;i<n;i++)
		if ( FloatRect(x+3,y+3,6,6).intersects(block[i].getGlobalBounds()) )
		     {block[i].setPosition(-100,0); dy=-dy;}

    if (x<0 || x>520)  dx=-dx;
    if (y<0 || y>450)  dy=-dy;

    if (Keyboard::isKeyPressed(Keyboard::Right)) sPaddle.move(10,0);
    if (Keyboard::isKeyPressed(Keyboard::Left)) sPaddle.move(-10,0);

	if ( FloatRect(x,y,12,12).intersects(sPaddle.getGlobalBounds()) ) dy=-(rand()%5+2);

	sBall.setPosition(x,y);
    app.clear();
    app.draw(sBackground);
    app.draw(sBall);
    app.draw(sPaddle);
    for (int i=0;i<n;i++)
     app.draw(block[i]);
    app.display();
    }
  return 0;
}