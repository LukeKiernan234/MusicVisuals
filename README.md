# Music Visualiser Project
---
# Group Members
| Name | Student Number |
|-----------|-----------|
|Luke Kiernan | insert |
|Hao Lin | insert |
|Vilim Mikic | C21737525 |
---
---
# Description of the assignment
- In this assignment, we have 2 visualisations each using Java processing.
Visualisations are based on the music track from the movie "Trainspotting" by Underworld. Track name is "Born Slippy". Visualisations are made to respond to the amplitude of the music and frequency bands. Audio analysis is done using the Minim library. 
---
# Instructions
- compile and run main.java from ie.tudublin package
- press space bar to pause/play music
- visualisatons can be changed by pressing 1, 2, 3, 4, 5, 6
- *Notice* : visualisations will change automatically at certain parts of the track
---
# How it works
- Each team member has its own directory containing the visualisations. 
- Aggregate file GroupVisual.java is used to run the visualisations, initialise the music, create the objects and call the methods from the visualisations. This file has been moved to ie.tudublin package for convenience.


## Vilim Mikic
- I created 2 visualisations. The first one is combination of 2D and 3D shapes. 
-The first visualisation is split in two parts. The first part is the outer circle in which the sticks represent the amplitude of the sound. At the end of each stick is an arc(half circle). Thanks to year 3 student to help me with maths(I find it hard to visualise sin and cos for some reason). The 2nd part of this visualisation is a sphere which rotation speed is base on the amplitude of the sound. The colour is based on the SmoothedAmplitude(comes from GroupVisual class).
![Vilim Visual 1](images/Vilim-1.png)






# What I am most proud of in the assignment

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

