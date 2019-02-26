#include <SFML/Graphics.hpp>
#include <stdlib.h>
#include <time.h>
using namespace sf;
const int A = 20;
const int B = 10;
int pole[A][B] = {0};
struct Punkt
{int x,y;} a[4], b[4];
int figury[7][4] =
{
    3,5,4,6,
	1,3,5,2,
	2,3,5,7,
	1,3,2,4,
    2,4,5,7,
	1,3,5,7,
	1,3,4,5,
};
bool sprawdz()
{
   for (int i=0;i<4;i++)
	  if (a[i].x<0 || a[i].x>=B || a[i].y>=A) return 0;
      else if (pole[a[i].y][a[i].x]) return 0;
   return 1;
};
int main()
{
    Texture t1,t2;
	t1.loadFromFile("images/klocki.png");
	t2.loadFromFile("images/gra.png");
    srand(time(NULL));
    Clock clock;
	RenderWindow window(VideoMode(320, 480), "Zagrajmy w gre :)");
	Sprite w(t1), background(t2);
    int dx=0; bool rotate=0; int colorNum=1;
	float timer=0,delay=0.4;
    while (window.isOpen())
    {
		float time = clock.getElapsedTime().asSeconds();
		clock.restart();
		timer+=time;
        Event ev;
        while (window.pollEvent(ev))
        {
            if (ev.type == Event::Closed)
                window.close();
			if (ev.type == Event::KeyPressed)
			  if (ev.key.code==Keyboard::Up) rotate=true;
			  else if (ev.key.code==Keyboard::Left) dx=-1;
			  else if (ev.key.code==Keyboard::Right) dx=1;
		}
	if (Keyboard::isKeyPressed(Keyboard::Down)) delay=0.06;
	for (int i=0;i<4;i++)  { b[i]=a[i]; a[i].x+=dx; }
    if (!sprawdz()) for (int i=0;i<4;i++) a[i]=b[i];
	/* obsluga rotacji*/
	if (rotate)
	  {
		Punkt p = a[1];
		for (int i=0;i<4;i++)
		  {
			int x = a[i].y-p.y;
			int y = a[i].x-p.x;
			a[i].x = p.x - x;
			a[i].y = p.y + y;
	 	  }
   	    if (!sprawdz()) for (int i=0;i<4;i++) a[i]=b[i];
	  }
	if (timer>delay)
	  {
	    for (int i=0;i<4;i++) { b[i]=a[i]; a[i].y+=1; }

		if (!sprawdz())
		{
		 for (int i=0;i<4;i++) pole[b[i].y][b[i].x]=colorNum;
		 colorNum=1+rand()%7+0;
		 int n=rand()%7+0;
		 for (int i=0;i<4;i++)
		   {
            a[i].y = figury[n][i] / 2;
		    a[i].x = figury[n][i] % 2;
		   }
		}
	  	timer=0;
	  }
	/* sprawdzanie linii */
    int q=A-1;
	for (int i=A-1;i>0;i--)
	{
		int count=0;
		for (int j=0;j<B;j++)
		{
		    if (pole[i][j]) count++;
		    pole[q][j]=pole[i][j];
		}
		if (count<B) q--;
	}
    dx=0; rotate=0; delay=0.3;
    window.clear(Color::Yellow);
    window.draw(background);
	for (int i=0;i<A;i++)
	 for (int j=0;j<B;j++)
	   {
         if (pole[i][j]==0) continue;
		 w.setTextureRect(IntRect(pole[i][j]*18,0,18,18));
		 w.setPosition(j*18,i*18);
		 w.move(28,30);
		 window.draw(w);
	   }
	for (int i=0;i<4;i++)
	  {
		w.setTextureRect(IntRect(colorNum*18,0,18,18));
		w.setPosition(a[i].x*18,a[i].y*18);
		w.move(28,32);
		window.draw(w);
	  }
 	window.display();
	}
    return 0;
}
