SnowFlake [] tons;
void setup()
{
  size(600,400);
  background(0);
  tons = new SnowFlake[200];
  for(int h = 0; h < tons.length; h++)
  {
    tons[h] = new SnowFlake();
  }
}
void draw()
{
  for(int i = 0; i < tons.length; i++)
  {
    tons[i].erase();
    tons[i].lookDown();
    tons[i].move();
    tons[i].wrap();
    tons[i].show();
    tons[i].cloud();
  }
}
void mouseDragged()
{
  if(mouseButton == RIGHT)
  {
    noStroke();
    fill(0);
    ellipse(mouseX,mouseY,15,15);
  }
  else
  {
    strokeWeight(10);
    stroke(0,0,255);
    line(mouseX,mouseY,pmouseX,pmouseY);
  }
}

class SnowFlake
{
  int x;
  int y;
  boolean isMoving;
  SnowFlake()
  {
    x = (int)(Math.random()*600);
    y = (int)(Math.random()*400);
    isMoving = true;
  }
  void show()
  {
    noStroke();
    fill(255);
    ellipse(x,y,7,7);
  }
  void lookDown()
  {
    if((y >= 0 && y <= 400) && (get(x,y+5) == color(0,0,255) || get(x,y+5) == color(255,255,255)))
    {
      isMoving = false;
    }
    else
    {
      isMoving = true;
    }
  }
  void erase()
  {
    fill(0);
    noStroke();
    ellipse(x,y,10,10);
  }
  void move()
  {
    if(isMoving == true)
    {
      y = y + 1;
    }
  }
  void wrap()
  {
    if(y > 390)
    {
      y = 0;
      x = (int)(Math.random()*580)+20;
    }
  }
  void cloud()
  {
    fill(127);
    for(int z = 50; z < 600; z = z + 100)
    {
      ellipse(z,0,130,50);
    }
  }
}


