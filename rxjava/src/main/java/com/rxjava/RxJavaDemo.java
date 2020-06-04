package com.rxjava;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class RxJavaDemo {
	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Observable<String> createObserver = Observable.create(new Observable.OnSubscribe<String>() {
			public void call(Subscriber<? super String> subscriber) {
				int count = 0;
				while (count++ < 10) {
					if (Math.random() > 0.7)
						throw new RuntimeException("Random error occurred..");
					subscriber.onNext("Hello World " + count);
				}

				subscriber.onCompleted();
			}
		});

		Subscriber<String> mySubscriber = new Subscriber<String>() {
			public void onNext(String s) {
				System.out.println("Subscriber onNext(): " + s);
			}

			public void onCompleted() {
				System.out.println("Subscriber completed..");
			}

			public void onError(Throwable e) {
				System.out.println("Error occured in Subscriber,"+e);
			}
		};

		Observer<String> myObserver = new Observer<String>() {
			public void onNext(String s) {
				System.out.println("Observer onNext(): " + s);
			}

			public void onCompleted() {
				System.out.println("Observer completed..");
			}

			public void onError(Throwable e) {
				System.out.println("Error occured in Observer,"+e);
			}
		};
		
		//Linking Observer, Subscribers to the Observable
		createObserver.subscribe(mySubscriber);
		createObserver.subscribe(myObserver);
	}
}
