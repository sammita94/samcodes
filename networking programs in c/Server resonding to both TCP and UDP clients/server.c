#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
main()
{
	/*Declaring the variables*/
	int tcpSocket,udpSocket,newtcpSocket ;
	struct sockaddr_in serv_addr,clientAddr;
  	struct sockaddr_storage serverStorage;
	socklen_t addr_size;
	fd_set readfds;
	struct timeval tv;

	int i,rv,nBytes,clilen,n,flag,len;
	char buf1[100], buf2[100];

	/*TCP socket*/

	//creating TCP socket
	if ((tcpSocket = socket(PF_INET, SOCK_STREAM, 0)) < 0) 
	{
		printf("Unable to create socket\n");
		exit(0);
	}

	//Initializing the socket variables
	serv_addr.sin_family= AF_INET;
	serv_addr.sin_addr.s_addr=inet_addr("127.0.0.1");
	serv_addr.sin_port=htons(50019);

	//Binding the TCP socket
	if (bind(tcpSocket, (struct sockaddr *) &serv_addr,sizeof(serv_addr)) < 0) 
	{
		printf("Unable to bind local address\n");
		exit(0);
	}
	
	//Listening to 5 calls
	listen(tcpSocket, 5);


	/*UDP Socket*/

	//creating UDP socket
	if ((udpSocket = socket(PF_INET, SOCK_DGRAM, 0)) <0)
	{
		printf("Unable to create socket\n");
		exit(0);
	}

	//Initializing the variables
	serv_addr.sin_family = AF_INET;
  	serv_addr.sin_port = htons(50019);
  	serv_addr.sin_addr.s_addr = inet_addr("127.0.0.1");
  	memset(serv_addr.sin_zero, '\0', sizeof serv_addr.sin_zero);

	//Binding the UDP socket
	if (bind(udpSocket, (struct sockaddr *) &serv_addr, sizeof(serv_addr)) < 0)
	{
		printf("Unable to bind local address\n");
		exit(0);
	} 

	addr_size = sizeof serverStorage;

	//finding the highest number of socket descriptor
	if (tcpSocket > udpSocket)
    		n = (tcpSocket + 1);
	else   
    		n = (udpSocket + 1);


	//Initializing the wait time to 20.5 s
	tv.tv_sec = 20;
	tv.tv_usec = 500000;

	while(1)
	{
		FD_ZERO(&readfds); //clearing the socket set 
		FD_SET(tcpSocket, &readfds);//adding TCP socket to the socket set for reading
		FD_SET(udpSocket, &readfds);//adding UDP socket to the socket set for reading
		rv = select(n, &readfds, NULL, NULL, NULL);
	
		if (rv == -1) 
		{
			perror("select"); // error occurred in select()
		} 
		else if (rv == 0) 
		{
			printf("Timeout occurred! No data after 20.5 seconds.\n");
		} 
		else 
		{
			// one or both of the descriptors have data
			if (FD_ISSET(tcpSocket, &readfds)) 
			{
				//clearing the buffer
				for(i=0;i<100;i++)
					buf1[i]='\0';
				
				//accepting the TCP client	
				clilen = sizeof(clientAddr);
				newtcpSocket = accept(tcpSocket, (struct sockaddr *) &clientAddr,&clilen) ;
				if (newtcpSocket < 0)
				{
					printf("Accept error\n");
					exit(0);
				}
	
				//receiving message from client
				read(newtcpSocket, buf1, 100);
				
				len = strlen(buf1);
				flag = 1;
				printf("Word Received at TCP socket is %s",buf1);
				printf("\n**************\n");
	
				//checking word is pallindrome or not
				for(i=0;i<=(len-1)/2;i++)
				{
					if(buf1[i]!=buf1[len-1-i])
					{	
						flag =0;
						break;
					}
				}
				if(flag == 1)
					strcpy(buf1,"Pallindrome");
				else
					strcpy(buf1,"Not Pallindrome");
	
				//sending the result to client		
				write(newtcpSocket,buf1,strlen(buf1)+1);
		
				//clearing the buffer for next iteration			
				for(i=0;i<100;i++)
					buf1[i]='\0';
				
			}
			if (FD_ISSET(udpSocket, &readfds)) 
			{
				//clearing the buffer
				for(i=0;i<100;i++)
					buf2[i]='\0';
				
				//receiving from UDP client 			
				nBytes = recvfrom(udpSocket,buf2,100,0,(struct sockaddr *)&serverStorage, &addr_size);
				len = strlen(buf2)-1;
				printf("Word Received at UDP socket is %s",buf2);
				printf("\n**************\n");
				flag = 1;
	
				//checking word is pallindrome or not
				for(i=0;i<=(len-1)/2;i++)
				{
					if(buf2[i]!=buf2[len-1-i])
					{	
						flag =0;
						break;
					}
				}
				if(flag == 1)
					strcpy(buf2,"Pallindrome");
				else
					strcpy(buf2,"Not Pallindrome");
	
				//sending result back to client			
				sendto(udpSocket,buf2,strlen(buf2)+1,0,(struct sockaddr *)&serverStorage,addr_size);
	
				//clearing the buffer for next iteration		
				for(i=0;i<100;i++)
					buf2[i]='\0';
				
			}
		}
	}
}

