import React, { forwardRef, useState, useEffect } from 'react'
import MaterialTable from "material-table";
import moment from 'moment'

import AddBox from '@material-ui/icons/AddBox';
import ArrowDownward from '@material-ui/icons/ArrowDownward';
import Check from '@material-ui/icons/Check';
import ChevronLeft from '@material-ui/icons/ChevronLeft';
import ChevronRight from '@material-ui/icons/ChevronRight';
import Clear from '@material-ui/icons/Clear';
import DeleteOutline from '@material-ui/icons/DeleteOutline';
import Edit from '@material-ui/icons/Edit';
import FilterList from '@material-ui/icons/FilterList';
import FirstPage from '@material-ui/icons/FirstPage';
import LastPage from '@material-ui/icons/LastPage';
import Remove from '@material-ui/icons/Remove';
import SaveAlt from '@material-ui/icons/SaveAlt';
import Search from '@material-ui/icons/Search';
import ViewColumn from '@material-ui/icons/ViewColumn';

const tableIcons = {
    Add: forwardRef((props, ref) => <AddBox {...props} ref={ref} />),
    Check: forwardRef((props, ref) => <Check {...props} ref={ref} />),
    Clear: forwardRef((props, ref) => <Clear {...props} ref={ref} />),
    Delete: forwardRef((props, ref) => <DeleteOutline {...props} ref={ref} />),
    DetailPanel: forwardRef((props, ref) => <ChevronRight {...props} ref={ref} />),
    Edit: forwardRef((props, ref) => <Edit {...props} ref={ref} />),
    Export: forwardRef((props, ref) => <SaveAlt {...props} ref={ref} />),
    Filter: forwardRef((props, ref) => <FilterList {...props} ref={ref} />),
    FirstPage: forwardRef((props, ref) => <FirstPage {...props} ref={ref} />),
    LastPage: forwardRef((props, ref) => <LastPage {...props} ref={ref} />),
    NextPage: forwardRef((props, ref) => <ChevronRight {...props} ref={ref} />),
    PreviousPage: forwardRef((props, ref) => <ChevronLeft {...props} ref={ref} />),
    ResetSearch: forwardRef((props, ref) => <Clear {...props} ref={ref} />),
    Search: forwardRef((props, ref) => <Search {...props} ref={ref} />),
    SortArrow: forwardRef((props, ref) => <ArrowDownward {...props} ref={ref} />),
    ThirdStateCheck: forwardRef((props, ref) => <Remove {...props} ref={ref} />),
    ViewColumn: forwardRef((props, ref) => <ViewColumn {...props} ref={ref} />)
  };

export default function RestockInventory() { 
    const [dataFromDB, setDataFromDB] = useState([])
    const [availabilityData, setAvailabilityData] = useState([])

    useEffect(()=> {
        const urlToFetchData = "http://localhost:8094/wholesale/getAll"
        fetch(urlToFetchData)
        .then(res => res.json())
        .then(data => {
            setDataFromDB(data)
        })
    },[])

    useEffect(()=> {
        const tempData = dataFromDB
        {tempData.map((object,i)=> {
            object.quantity = 0
            object.index = i + 1
            // object.expiration = moment(moment(object.expiry_date).format()).toDate()
            object.expiration = new Date()
        })}
        setAvailabilityData(tempData)
        console.log("From the fb")
        console.log(tempData)
    },[dataFromDB])

    const handleSubmit = (e) => {
        e.preventDefault()
        let finalData = {}
        finalData["order_date"] = new Date()
        finalData["wholesale_items"] = availabilityData
        finalData["wholesale_items"].map(object => {
            delete object.index
            delete object.id
            delete object.expiry_date
        })
        console.log("Final Data")
        console.log(finalData)

        const dummyData = {
            "order_date": new Date(),
            "wholesale_items": [{
                "name": "moonUnique",
                "quantity": 100,
                "price": 0.05,
                "expiration": new Date()
            },
            {
                "name": "carrots",
                "quantity": 100,
                "price": 0.2,
                "expiration": new Date()
            }]
        }
        console.log("Dummy Dtaa")
        console.log(dummyData)
        const urlToSendData = "http://localhost:8094/wholesale/buy"
        fetch(urlToSendData, {
        method: "POST",
        headers: { 
            Accept: 'application/json',
            "Content-Type": "application/json",
            'Access-Control-Request-Method': '*',
        },
        body: JSON.stringify(finalData)
        }).then(res => {
            console.log(res)
        }).catch(error => {
            console.log(error.message);
          })
    }

    const updateData = (newValue,rowIndex) => {
        let newObject = {}
        let newData = availabilityData
        availabilityData.map(object => {
            if(object.index === rowIndex){
                newObject = object
            }
        })
        newObject.quantity = parseFloat(newValue)
        newData[rowIndex] = newObject
        setAvailabilityData(newData)
    }

    return(
        <div className="restock-inventory"> 
            <div style={{ maxWidth: "900%",marginLeft:"2em",marginRight:"1em", paddingTop:"2em"}}>
                <MaterialTable
                options={{
                    paging:true,
                    pageSize:6,
                    searchAutoFocus: true
                }}
                icons={tableIcons}
                cellEditable={{
                    cellStyle: {},
                    onCellEditApproved: (newValue, oldValue, rowData, columnDef) => {
                        return new Promise((resolve, reject) => {
                            setTimeout(resolve, 1000);
                            updateData(newValue,rowData.index)
                        });
                    }
                }}
                columns={[
                { title: "No.", field: "index", type:"string", editable:"never"},
                { title: "Name", field: "name", type:"string", editable:"never"},
                { title: "Price", field: "price", editable:"never"},
                { title: "Expiry Date", field: "expiry_date", type: "date",editable:"never" },
                { title: "Quantity", field: "quantity"},
                ]}
                data={availabilityData}
                title="Buy Items"
                />
        </div>
        <button onClick={e=>handleSubmit(e)} className="submit">Submit</button>
      </div>
    )
}
