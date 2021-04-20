import React from 'react'
import * as AiIcons from 'react-icons/ai'
import * as BiIcons from 'react-icons/bi'
import * as VscIcons from 'react-icons/vsc'
import * as GoIcons from 'react-icons/go'
import * as FaIcons from 'react-icons/fa'


export const SidebarData = [
    {
        title:'Dashboard',
        path:'/',
        icon: <AiIcons.AiFillHome />,
        cName: 'nav-text'
    },
    {
        title:'View Inventory',
        path:'/view-inventory',
        icon: <VscIcons.VscPreview/>,
        cName: 'nav-text'
    },
    {
        title:'Restock Inventory',
        path:'/restock-inventory',
        icon: <FaIcons.FaDollarSign />,
        cName: 'nav-text'
    },
    {
        title:'Statistics',
        path:'/statistics',
        icon: <GoIcons.GoGraph />,
        cName: 'nav-text'
    },
]