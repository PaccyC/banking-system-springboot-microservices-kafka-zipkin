

const transactionList = [
    {
        "date": "17, Apr, 2023",
        "status":"Complete",
        "transaction_type":"Credit",
        "receipt": "3478REUIUJXHDF",
        "amount":160.00
    },
    {
        "date": "17, Apr, 2023",
        "status":"Complete",
        "transaction_type":"Credit",
        "receipt": "3478REUIUJXHDF",
        "amount":160.00
    },
    {
        "date": "17, Apr, 2023",
        "status":"Complete",
        "transaction_type":"Credit",
        "receipt": "3478REUIUJXHDF",
        "amount":160.00
    },
    {
        "date": "17, Apr, 2023",
        "status":"Complete",
        "transaction_type":"Credit",
        "receipt": "3478REUIUJXHDF",
        "amount":160.00
    },
    
]
const AccountDetails = () => {
    return (
      <div className="w-full flex flex-col gap-8">
        <div className="flex flex-col gap-4">
          <h3 className="font-inter font-normal text-[22px] text-gray-1">Account Details</h3>
          <div className="bg-white rounded-[12px] w-full px-6 py-8 shadow-lg">
            <div className="flex flex-col gap-6">
              <div className="flex gap-44">
                <div className="flex flex-col gap-12">
                  <div className="flex flex-col gap-0">
                    <p className="font-inter font-normal text-[14px] text-light-gray-4">Account Number</p>
                    <h3 className="font-inter font-semibold text-[20px] text-dark-1">AB Bank Ltd.</h3>
                  </div>
                  <div className="flex flex-col gap-0">
                    <p className="font-inter font-normal text-[14px] text-light-gray-4">Branch Name</p>
                    <h3 className="font-inter font-semibold text-[20px] text-dark-1">Park Street Branch</h3>
                  </div>
                </div>
                <div className="flex flex-col gap-12">
                  <div className="flex flex-col gap-0">
                    <p className="font-inter font-normal text-[14px] text-light-gray-4">Account Type</p>
                    <h3 className="font-inter font-semibold text-[20px] text-dark-1">Checking</h3>
                  </div>
                  <div className="flex flex-col gap-0">
                    <p className="font-inter font-normal text-[14px] text-light-gray-4">Account Number</p>
                    <h3 className="font-inter font-semibold text-[20px] text-dark-1">3388 4556 8860 8***</h3>
                  </div>
                </div>
                <div className="flex flex-col gap-0">
                  <p className="font-inter font-normal text-[14px] text-light-gray-4">Balance</p>
                  <h3 className="font-inter font-semibold text-[20px] text-dark-1">$25,056.00</h3>
                </div>
              </div>
  
              <div className="flex gap-4 items-center">
                <button className="text-white bg-primary-1 rounded-[4px] py-4 px-16 font-inter font-bold text-[16px] flex gap-2 items-center justify-center">
                  Edit Details
                </button>
                <p className="font-inter font-semibold text-[14px] text-gray-1 cursor-pointer">
                  Remove
                </p>
              </div>
            </div>
          </div>
        </div>
  
        <div className="flex flex-col gap-4">
          <h3 className="font-inter font-normal text-[22px] text-gray-1">Transactions History</h3>
          <div className="bg-white rounded-[12px] w-full px-6 py-8 shadow-lg flex flex-col gap-4">
            <table className="w-full">
              <thead>
                <tr className="text-left">
                  <th className="px-4 py-2 text-dark-1 font-inter text-[20px] text-start">Date</th>
                  <th className="px-4 py-2 text-dark-1 font-inter text-[20px] text-center">Status</th>
                  <th className="px-4 py-2 text-dark-1 font-inter text-[20px] text-center">Transaction Type</th>
                  <th className="px-4 py-2 text-dark-1 font-inter text-[20px] text-center">Receipt</th>
                  <th className="px-4 py-2 text-dark-1 font-inter text-[20px] text-center">Amount</th>
                </tr>
              </thead>
              <tbody>
                {transactionList.map((transaction) => (
                  <tr key={transaction.receipt} className=" border-light-gray-5">
                    <td className="px-4 py-2 text-gray-1 text-[16px] font-inter font-medium">{transaction.date}</td>
                    <td className="px-4 py-2 text-gray-1 text-[16px] font-inter font-medium text-center">{transaction.status}</td>
                    <td className="px-4 py-2 text-gray-1 text-[16px] font-inter font-medium text-center">{transaction.transaction_type}</td>
                    <td className="px-4 py-2 text-gray-1 text-[16px] font-inter font-medium text-center">{transaction.receipt}</td>
                    <td className="px-4 py-2 text-dark-1 text-[16px] font-inter font-semibold text-center">${transaction.amount}</td>
                  </tr>
                ))}
              </tbody>
            </table>
            <button className="text-white bg-primary-1 rounded-[4px] py-4 px-16 font-inter font-bold text-[16px] flex gap-2 items-center justify-center self-center">
                  Load More
                </button>

          </div>
        </div>
      </div>
    );
  };
  
  export default AccountDetails;
  