import React, { forwardRef } from 'react'
import MaterialTable from "material-table";

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
    return(
        <div className="restock-inventory"> 
            <div style={{ maxWidth: "900%",marginLeft:"2em",marginRight:"1em", paddingTop:"2em"}}>
                <MaterialTable
                options={{
                    paging:true,
                    pageSize:9,
                    searchAutoFocus: true
                }}
                icons={tableIcons}
                cellEditable={{
                    cellStyle: {},
                    onCellEditApproved: (newValue, rowData) => {
                        return new Promise((resolve, reject) => {
                            setTimeout(resolve, 1000);
                            rowData.quantity = newValue;
                        });
                    }
                }}
                columns={[
                { title: "No.", field: "index", type:"string", editable:"never"},
                { title: "Name", field: "name", type:"string", editable:"never"},
                { title: "Price", field: "price", editable:"never"},
                { title: "Expiry Date", field: "exp_date", type: "string",editable:"never" },
                { title: "Quantity", field: "quantity"},
                ]}
                data={[
                {
                    index: "1",
                    name: "Banana",
                    price: 34.6,
                    exp_date: "2021-05-07",
                    quantity: 0,
                },
                {
                    index: "2",
                    name: "Eggs",
                    price: 31.6,
                    exp_date: "2021-05-09",
                    quantity: 0,
                },
                {
                    index: "2",
                    name: "Eggs",
                    price: 31.6,
                    exp_date: "2021-05-09",
                    quantity: 0,
                },
                {
                    index: "2",
                    name: "Eggs",
                    price: 31.6,
                    exp_date: "2021-05-09",
                    quantity: 0,
                },
                {
                    index: "2",
                    name: "Eggs",
                    price: 31.6,
                    exp_date: "2021-05-09",
                    quantity: 0,
                },
                {
                    index: "2",
                    name: "Eggs",
                    price: 31.6,
                    exp_date: "2021-05-09",
                    quantity: 0,
                },
                {
                    index: "2",
                    name: "Eggs",
                    price: 31.6,
                    exp_date: "2021-05-09",
                    quantity: 0,
                },
                {
                    index: "2",
                    name: "Eggs",
                    price: 31.6,
                    exp_date: "2021-05-09",
                    quantity: 0,
                },
                {
                    index: "2",
                    name: "Eggs",
                    price: 31.6,
                    exp_date: "2021-05-09",
                    quantity: 0,
                },

                ]}
                title="Buy Items"
                />
        </div>
      </div>
    )
}