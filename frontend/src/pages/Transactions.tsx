import TransactionFilter from "../components/TransactionFilter"


const transactionList = [
  {
    "itemName":"GTR 5",
    "image":"/icons/gamepad.svg",
    "shopName":"Gadhet & Gear",
    "date":"17 May, 2023",
    "paymentMethod":"Credit Card",
    "amount":160
  },
  {
    "itemName":"Biriyani",
    "image":"/icons/Shopping.svg",
    "shopName":"XL fashions",
    "date":"17 May, 2023",
    "paymentMethod":"Credit Card",
    "amount":160
  },
  {
    "itemName":"Movie Bucket",
    "image":"/icons/gamepad.svg",
    "shopName":"Inox",
    "date":"17 May, 2023",
    "paymentMethod":"Credit Card",
    "amount":160
  },
  {
    "itemName":"Taxi Fare",
    "image":"/icons/Trasnport.svg",
    "shopName":"Uber",
    "date":"17 May, 2023",
    "paymentMethod":"Credit Card",
    "amount":160
  },
  {
    "itemName":"Pizza",
    "image":"/icons/gamepad.svg",
    "shopName":"Pizza Hit",
    "date":"17 May, 2023",
    "paymentMethod":"Credit Card",
    "amount":160
  },
  {
    "itemName":"Keyboard",
    "image":"/icons/gamepad.svg",
    "shopName":"Gadhet & Gear",
    "date":"17 May, 2023",
    "paymentMethod":"Credit Card",
    "amount":160
  },
  {
    "itemName":"GTR 5",
    "image":"/icons/gamepad.svg",
    "shopName":"Gadhet & Gear",
    "date":"17 May, 2023",
    "paymentMethod":"Credit Card",
    "amount":160
  }
]
const Transactions = () => {
  return (
    <div className=" flex flex-col gap-8 w-full">
       <h3 className="font-inter font-normal text-[22px] text-gray-1">Recent Transaction</h3>
       <TransactionFilter/>

       <div className=" bg-white min-h-[200px] rounded-[12px] shadow-lg px-6 py-8 flex flex-col gap-4">
        <table className=" w-full">
          <thead>
            <tr className=" border-b-[2px] border-gray-5">
              <th className="px-4 py-2 text-dark-1 font-inter first-line:text-[20px] text-start">Items</th>
              <th className="px-4 py-2 text-dark-1 font-inter first-line:text-[20px] text-center">Shop Name</th>
              <th className="px-4 py-2 text-dark-1 font-inter first-line:text-[20px] text-center">Date</th>
              <th className="px-4 py-2 text-dark-1 font-inter first-line:text-[20px] text-center">Payment Method</th>
              <th className="px-4 py-2 text-dark-1 font-inter first-line:text-[20px] text-center">Amount</th>
            </tr>
          </thead>
          <tbody>
            {transactionList.map((transaction)=>(
              <tr key={transaction.itemName} className="border-b-[2px] border-gray-5">
                <td className="flex gap-4 items-center px-4 py-6 text-gray-1 text-[16px] font-inter font-medium text-center  ">
                  <img src={transaction.image} alt={`${transaction.itemName} image`} />
                  {transaction.itemName}
                </td>
                <td className="px-4 py-6 text-gray-1 text-[16px] font-inter font-medium text-center">{transaction.shopName}</td>
                <td className="px-4 py-6 text-gray-1 text-[16px] font-inter font-medium text-center">{transaction.date}</td>
                <td className="px-4 py-6 text-gray-1 text-[16px] font-inter font-medium text-center">{transaction.paymentMethod}</td>
                <td className="px-4 py-6 text-dark-1  text-[16px] font-inter font-semibold text-center">${transaction.amount}</td>
              </tr>
            ))}
          </tbody>
        </table>
        <div className=" flex w-full justify-center">
        <button className="text-white bg-primary-1 rounded-[4px] py-4 px-16 font-inter font-bold text-[16px] flex gap-2 items-center justify-center self-center">
                  Load More
       </button>
       </div>        
       </div>
    </div>
  )
}

export default Transactions