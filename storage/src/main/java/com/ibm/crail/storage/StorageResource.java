/*
 * Crail: A Multi-tiered Distributed Direct Access File System
 *
 * Author: Patrick Stuedi <stu@zurich.ibm.com>
 *
 * Copyright (C) 2016, IBM Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.ibm.crail.storage;

public class StorageResource {
	private long address;
	private int length;
	private int key;
	
	public static StorageResource createResource(long address, int length, int key){
		return new StorageResource(address, length, key);
	}
	
	private StorageResource(long address, int length, int key){
		this.address = address;
		this.length = length;
		this.key = key;
	}

	public long getAddress() {
		return address;
	}

	public int getLength() {
		return length;
	}

	public int getKey() {
		return key;
	}
}
