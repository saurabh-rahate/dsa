const delay = async (ms: number) => {
    return new Promise(resolve => setTimeout(resolve, ms));
}

const hello = async () => {
    console.log('Hi');
    await delay(1000);
    console.log('Hi');
}


hello();