import React from 'react'
import ClassCard from '../Components/ClassCard'
import StatsChart from '../Components/Chart'
import { useHistory } from "react-router-dom";

export default function Dashboard() {
    const history = useHistory()

    const mockData = [
        {
         emp_name:"Aryan",
         date:"4 March" ,
         amount:"$2000"
        },
        {
            emp_name:"Monica",
            date:"7 March" ,
            amount:"$100"
        },
        {
            emp_name:"Arlan",
            date:"20 March" ,
            amount:"$3000"
        }
    ]
    return(
        <div className="dashboard">
            {/* <div className="title-container">
                Inventory Management
            </div> */}
            <div className="container-1">          
            <div className="button-container">
                <button className="box-1"> 
                    Inventory
                </button>
                <button className="box-2" >
                    Restock 
                </button>
                <button className="box-3" >
                    Statistics 
                </button>
            </div>
            <div className="graph-container">
            <ClassCard code="Recent Invoices" name="01 March, 2021 to 30 March, 2021 " emp_data={mockData} />
            <StatsChart /> 
            </div>
            </div>
        </div>
    ) 
}