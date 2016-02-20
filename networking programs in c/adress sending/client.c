/*Group No.:13
Sammita Chakravarti(13/CS/18)
Shreya Ghosh(13/CS/25)*/

/*client sends server a message and recieves it back from the server. Also the address of the host machine of server is printed by client and vice versa*/

#include<stdio.h>
#include <stdlib.h>
#include <string.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<arpa/inet.h>
#include <arpa/inet.h>

#include <netdb.h>

main()
{
	int sockfd ;
	struct sockaddr_in serv_addr;
	int i,p,l;
	char buf[100],*buffer;

	if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0) 
	{
		printf("Unable to create socket\n");
		exit(0);
	}

	serv_addr.sin_family= AF_INET;
	serv_addr.sin_addr.s_addr=inet_addr("127.0.0.1");
	serv_addr.sin_port=htons(50020);

	for(i=0; i < 100; i++) 
		buf[i] = '\0';


	if ((connect(sockfd, (struct sockaddr *) &serv_addr,sizeof(serv_addr))) < 0) 
	{
		printf("Unable to connect to server\n");
		exit(0);
	}
	printf("Enter the statement:");
	scanf("%s",buf);
		
	l=0;
	while(l<strlen(buf))
	{
		printf("Sending to server\n***********************\n");
		p=send(sockfd, buf, strlen(buf) + 1, 0);
		if(p<0)
		{
			printf("Error in sending to server\n");
			exit(0);
		}
		l = l + p;
				
	}
	
	l=0;
	while(l<strlen(buf))
	{
		printf("Recieving from server\n*********\n");
		p=recv(sockfd, buf, 100, 0);
		if(p<0)
		{
			printf("Error in reciving from server\n");
			exit(0);
		}
		l = l + p;
		printf("%s\n",buf);
				
				
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
 	}

	while(l<strlen(buffer))
	{
		printf("Sending to server\n***********************\n");
		p=send(sockfd, buffer, strlen(buffer) + 1, 0);
		if(p<0)
		{
			printf("Error in sending to server\n");
			exit(0);
		}
		l = l + p;
				
	}
	

	l=0;
	while(l<strlen(buf))
	{
		printf("Waiting for server!!\n**********\n");
		p=recv(sockfd, buf, 100, 0);
		if(p<0)
		{
			printf("Error in reciving from client");
			exit(0);
		}
		l = l + p;
		if(l == strlen(buffer))
			break;
				//printf("%d",l);
				
	}			
			
	printf("Server Address: %s\n",buffer);

	exit(0);			
	close(sockfd);
}
