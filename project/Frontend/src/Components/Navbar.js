import React,{ useState } from 'react'
import { Link } from 'react-router-dom'
import { SidebarData } from './SidebarData'
import './Navbar.css'
import { IconContext } from 'react-icons'
export default function Navbar() {
    // const [sidebar,setSidebar] = useState(false)
    // const showSidebar = () => setSidebar(!sidebar)
    
    return (
        <>
        <IconContext.Provider value={{'color':"white"}}>
            <div className="navbar">
            </div>
            <nav className={'nav-menu active'}> 
                <ul className='nav-menu-items' >  
                    <li className="navbar-toggle">
                    </li>
                    {SidebarData.map((item,index)=> {
                        return (
                            <li key={index} className={item.cName}>
                                <Link to={item.path}>
                                    {item.icon}
                                   <span> {item.title}</span>
                                </Link>
                            </li>
                        )
                    })}
                </ul>
            </nav>
          </IconContext.Provider>
        </>
    )
}

