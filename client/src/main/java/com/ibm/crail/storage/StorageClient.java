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

import java.io.IOException;
import com.ibm.crail.conf.Configurable;
import com.ibm.crail.metadata.DataNodeInfo;

public interface StorageClient extends Configurable {
	public abstract StorageEndpoint createEndpoint(DataNodeInfo info) throws IOException;	
	public abstract void close() throws Exception;
	
	@SuppressWarnings("unchecked")
	public static StorageClient createInstance(String name) throws Exception {
		Class<?> nodeClass = Class.forName(name);
		if (StorageClient.class.isAssignableFrom(nodeClass)){
			Class<? extends StorageClient> storageClientClass = (Class<? extends StorageClient>) nodeClass;
			StorageClient client = storageClientClass.newInstance();
			return client;
		} else {
			throw new Exception("Cannot instantiate storage client of type " + name);
		}
		
	}	
}
