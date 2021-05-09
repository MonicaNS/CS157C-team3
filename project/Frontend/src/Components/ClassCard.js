import React from 'react'
import '../App.css'
export default function ClassCard({ code, name, emp_data}) {
    return(
        <div className="class-card">
            <div className="class-code" >{code}</div>
            <div className="label">Period</div>
            <div className="class-details">{name}</div>
            <br/>
            <table className="recent-invoice">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Date</th>
                        <th>Amount</th>
                    </tr>
                </thead>
                <tbody>
                    {emp_data.map(data=>{
                        return(
                        <tr>
                            <td>{data.emp_name}</td>
                            <td>{data.date}</td>
                            <td>{data.amount}</td>
                        </tr>
                        )
                    })}
                </tbody>
            </table>
        </div>
    ) 
}


