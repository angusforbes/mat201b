#include <stdlib.h>
#include <glut.h>
#include <math.h>
#define PI 3.14159265

float G_rot=0.0;
float G_k=1.0;
int G_n=1;


//void keyboard(unsigned char key, int x, int y);
//void timerRot(int value);


void display(void)
{

	float r,x,y,a;
	int th,step;

	a = 1.0;

//	glPushMatrix();
//	glRotatef(G_rot,0.0,0.0,1.0);

    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    glColor4f(1.0,1.0,1.0,1.0);
	
	
	//glBegin( GL_LINE_STRIP );
	//	for (th = 0 ;th<360;th++){
	//		r=a*cos(G_k*th*(PI/180.0));
	//		x = r*cos(th*(PI/180.0));
	//		y = r*sin(th*(PI/180.0));
	//		glVertex2f(x,y);
	//	}
	//glEnd();
	

	//glBegin( GL_LINE_STRIP );
	//	for (th = 0,step =0 ;th<360;th++, step+=G_n){
	//		r=a*cos(G_k*step*(PI/180.0));
	//		x = r*cos(step*(PI/180.0));
	//		y = r*sin(step*(PI/180.0));
	//		glVertex2f(x,y);
	//	}
	//glEnd();



//   glPopMatrix();


    glutSwapBuffers();
}

void reshape(int width, int height)
{
    glViewport(0, 0, width, height);
}

void idle(void)
{
    glutPostRedisplay();
}





int main(int argc, char** argv)
{
    glutInit(&argc, argv);
    
    glutInitDisplayMode(GLUT_RGBA | GLUT_DOUBLE | GLUT_DEPTH);
    glutInitWindowSize(640, 480);
    
    glutCreateWindow("GLUT Program");
    
    glutDisplayFunc(display);
    glutReshapeFunc(reshape);
    glutIdleFunc(idle);
	glClearColor(0.0,0.0,0.0,0.0);

	//glutKeyboardFunc(keyboard);
    //glutTimerFunc(10,timerRot,0);


    glutMainLoop();
    return EXIT_SUCCESS;
}

//void keyboard(unsigned char key, int x, int y){
//  if(key=='p'){
//	  G_k+=.1;
//      }
// if(key=='m'){
//	 G_k-=.1;
//      }
//  if(key=='o'){
//	  G_n++;
//      }
// if(key=='n'){
//	 G_n--;
//	 G_n=G_n<1?1:G_n;
//      }
//}




//void timerRot(int value){
//  // get new color or a value in [0,1]
//	G_rot+=PI/4.0;
//  glutTimerFunc(10,timerRot,0);
//}
