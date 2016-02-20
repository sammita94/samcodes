/*Group No.:13
Sammita Chakravarti(13/CS/18)
Shreya Ghosh(13/CS/25)*/


/*client sends server a message and recieves it back from the server. Also the address of the host machine of server is printed by client and vice versa*/


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <arpa/inet.h>

#include <netdb.h>
main()
{
	int sockfd, newsockfd ; /* Socket descriptors */
	int clilen;
	struct sockaddr_in cli_addr, serv_addr;
	int i,p,l;
	char buf[100],*buffer,c;

	//unlink("127.0.0.1");

	if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0) 
	{
		printf("Cannot create socket\n");
		exit(0);
	}

	serv_addr.sin_family = AF_INET;
	serv_addr.sin_addr.s_addr = INADDR_ANY;
	serv_addr.sin_port = htons(50020);

	memset(serv_addr.sin_zero, '\0', sizeof (serv_addr.sin_zero));

	if (bind(sockfd, (struct sockaddr *) &serv_addr,sizeof(serv_addr)) < 0) 
	{
		printf("Unable to bind local address\n");
		exit(0);
	}

	listen(sockfd, 5);

	 
	
		//flag =0;
		clilen = sizeof(cli_addr);
		newsockfd = accept(sockfd, (struct sockaddr *) &cli_addr,&clilen) ;
		if (newsockfd < 0)
		{
			printf("Accept error\n");
			exit(0);
		}

		printf("Server got connection from client %s\n", inet_ntoa(cli_addr.sin_addr));

		
		
			l=0;
			while(l<strlen(buf))
			{
				printf("Waiting for client\n**********\n");
				p=recv(newsockfd, buf, 100, 0);
				if(p<0)
				{
					printf("Error in reciving from client");
					exit(0);
				}
				l = l + p;
				//printf("%d",l);
				
			}
			l=0;
			printf("%s\n",buf);
			while(l<strlen(buf))
			{
				printf("Sending to client\n**********\n");
				p=send(newsockfd, buf, strlen(buf) + 1, 0);
				if(p<0)
				{
					printf("Error in sending to client\n");
					exit(0);
				}
				l = l + p;
				//printf("%d",l);
				
			}
			
			gethostname(buf,sizeof buf);
			struct hostent *hp = gethostbyname(buf);
			if (hp == NULL) 
			{
				fprintf(stderr,"gethostbyname() failed\n");
				exit(1);
 			}
			else 
			{
				//printf("%s = ", hp->h_name);
				unsigned int i=0;
				while ( hp -> h_addr_list[i] != NULL) 
				{
     					buffer = inet_ntoa( *( struct in_addr*)( hp -> h_addr_list[i]));
     					i++;
   				}
   				printf("\n");
//   exit(0);
			}

			l=0;
			while(l<strlen(buf))
			{
				printf("Waiting for client\n**********\n");
				p=recv(newsockfd, buf, 100, 0);
				if(p<0)
				{
					printf("Error in reciving from client");
					exit(0);
				}
				l = l + p;
				//printf("%d",l);
				
			}			
			

			l =0;
			
			while(l<strlen(buffer))
			{
				printf("Sending to client\n***********************\n");
				p=send(newsockfd, buffer, strlen(buffer) + 1, 0);
				//printf("%d",p);
				if(p<0)
				{
					printf("Error in sending to client\n");
					exit(0);
				}
				l = l + p;
				
			}
			printf("Client Address: %s\n",buf);
			exit(0);
			close(newsockfd);
	
}

