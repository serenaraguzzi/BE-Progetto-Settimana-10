PGDMP                         z            piattaformafilm    14.1    14.1 	    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16684    piattaformafilm    DATABASE     k   CREATE DATABASE piattaformafilm WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE piattaformafilm;
                postgres    false            ?            1259    16735    film    TABLE     ?   CREATE TABLE public.film (
    id integer NOT NULL,
    anno integer,
    incasso character varying(255),
    regista character varying(255),
    tipo character varying(255),
    titolo character varying(255)
);
    DROP TABLE public.film;
       public         heap    postgres    false            ?            1259    16734    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?          0    16735    film 
   TABLE DATA           H   COPY public.film (id, anno, incasso, regista, tipo, titolo) FROM stdin;
    public          postgres    false    210   ?       ?           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 8, true);
          public          postgres    false    209            ]           2606    16741    film film_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
       public            postgres    false    210            ?     x?U?˒?0?ux
?F@E?D?yAAl??D??M?>??S?]՛?????s?????????p9??{???v???v?j???#?(??F???{{????Z???!'??jk|??a,?I???L???????AJ?0hxR???i?N?O?"??@?_,????'ϳe^r? ???qƸ???⤮1W??X???q?$WW?F4W?/??vw?????I?m???m???h?~???/?&?š?A3?"q????-81??U{???ipN?CrJ?J???؜e??T????????o?+'DHۇ͌??7Z?< #?x?iDSwaZ`Ͱ?f?Q`w??????Q?!?>?!??.??Ik??7??+???g??3?΋??D??߇}R?Q^?H_?`9?&???ipX?? ~W7?C)?2??a????
?~?Zᮺ?=??X?v?J?'??r?3?[΢??4A???`?B ?K??u??]??2eȃI??U1??K??N6?-($z????lN??k?@V4?rX????(? ?_?o     