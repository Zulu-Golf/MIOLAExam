import React from 'react';
import * as FaIcons from 'react-icons/fa';
import * as AiIcons from 'react-icons/ai';
import * as IoIcons from 'react-icons/io';

export const SidebarData = [
  {
    title: 'Home',
    path: '/',
    icon: <AiIcons.AiFillHome />,
    cName: 'nav-text'
  },
  {
    title: 'Examens',
    path: '/examens',
    icon: <IoIcons.IoIosPaper />,
    cName: 'nav-text'
  },
  {
    title: 'Enseignant',
    path: '/enseignant',
    icon: <IoIcons.IoMdSchool />,
    cName: 'nav-text'
  },
  {
    title: 'Salles',
    path: '/salle',
    
    cName: 'nav-text'
  },
  {
    title: 'Etudiants',
    path: '/etudiant',
    icon: <IoIcons.IoMdPeople />,
    
    cName: 'nav-text'
  },
  {
    title: 'Cours',
    path: '/cour',
    icon: <IoIcons.IoMdPeople />,
    
    cName: 'nav-text'
  },

];
