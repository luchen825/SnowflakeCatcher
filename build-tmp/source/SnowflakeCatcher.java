import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] tons;
public void setup()
{
  size(600,400);
  background(0);
  tons = new SnowFlake[200];
  for(int h = 0; h < tons.length; h++)
  {
    tons[h] = new SnowFlake();
  }
}
public void draw()
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
public void mouseDragged()
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
  public void show()
  {
    noStroke();
    fill(255);
    ellipse(x,y,7,7);
  }
  public void lookDown()
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
  public void erase()
  {
    fill(0);
    noStroke();
    ellipse(x,y,10,10);
  }
  public void move()
  {
    if(isMoving == true)
    {
      y = y + 1;
    }
  }
  public void wrap()
  {
    if(y > 390)
    {
      y = 0;
      x = (int)(Math.random()*580)+20;
    }
  }
  public void cloud()
  {
    fill(127);
    for(int z = 50; z < 600; z = z + 100)
    {
      ellipse(z,0,130,50);
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
