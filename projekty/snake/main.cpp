#include <SFML/Graphics.hpp>
#include <time.h>
using namespace sf;
int A=30,B=15;
int size=16;
int w = size*A;
int h = size*B;
int dir;
int num=2;
struct Snake
{ int x,y;}  s[100];
struct Fruct
{ int x,y;} f;
void Ziarno()
 {
    for (int i=num;i>0;--i)
	 {s[i].x=s[i-1].x;
	 s[i].y=s[i-1].y;}

    if (dir==0) s[0].y+=1;
    if (dir==1) s[0].x-=1;
    if (dir==2) s[0].x+=1;
    if (dir==3) s[0].y-=1;

	if ((s[0].x==f.x) && (s[0].y==f.y))
      { num++;
    	f.x=rand() % A;
        f.y=rand() % B; }

    if (s[0].x>A) s[0].x=0;  if (s[0].x<0) s[0].x=A;
    if (s[0].y>B) s[0].y=0;  if (s[0].y<0) s[0].y=B;

    for (int i=1;i<num;i++)
     if (s[0].x==s[i].x && s[0].y==s[i].y)  num=i;
 }
int main()
{
	srand(time(0));
    RenderWindow window(VideoMode(w, h), "Zagrajmy w gre :)");
	Texture t1,t2,t3;
	t1.loadFromFile("images/white.png");
	t2.loadFromFile("images/blue.png");
	t3.loadFromFile("images/brown.png");
	Sprite sprite1(t1);
	Sprite sprite2(t2);
	Sprite sprite3(t3);
	Clock clock;
    float timer=0, delay=0.1;
	f.x=10;
    f.y=10;
    while (window.isOpen())
    {
		float time = clock.getElapsedTime().asSeconds();
		clock.restart();
        timer+=time;
        Event e;
        while (window.pollEvent(e))
        {
            if (e.type == Event::Closed)
                window.close();
		}
		if (Keyboard::isKeyPressed(Keyboard::Left)) dir=1;
	    if (Keyboard::isKeyPressed(Keyboard::Right))  dir=2;
	    if (Keyboard::isKeyPressed(Keyboard::Up)) dir=3;
		if (Keyboard::isKeyPressed(Keyboard::Down)) dir=0;

		if (timer>delay) {timer=0; Ziarno();}
  /*rysowanie*/
    window.clear();
    for (int i=0; i<A; i++)
	  for (int j=0; j<B; j++)
		{ sprite1.setPosition(i*size,j*size);  window.draw(sprite1); }
	for (int i=0;i<num;i++)
	    { sprite2.setPosition(s[i].x*size, s[i].y*size);  window.draw(sprite2); }
	sprite3.setPosition(f.x*size,  f.y*size);  window.draw(sprite3);
	window.display();
	}
    return 0;
}
