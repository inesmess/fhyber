/*
 * Crail: A Multi-tiered Distributed Direct Access File System
 *
 * Author:
 * Jonas Pfefferle <jpf@zurich.ibm.com>
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

package com.ibm.crail.storage.nvmf.client;

import com.ibm.crail.CrailBuffer;
import com.ibm.disni.nvmef.spdk.NvmeStatusCodeType;

import java.io.IOException;

/**
 * Created by jpf on 23.05.17.
 */
public class NvmfStorageUnalignedWriteFuture extends NvmfStorageFuture {

	private CrailBuffer stagingBuffer;

	public NvmfStorageUnalignedWriteFuture(NvmfStorageEndpoint endpoint, int len, CrailBuffer stagingBuffer) {
		super(endpoint, len);
		this.stagingBuffer = stagingBuffer;
	}

	@Override
	void signal(NvmeStatusCodeType statusCodeType, int statusCode) {
		try {
			endpoint.putBuffer(stagingBuffer);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		super.signal(statusCodeType, statusCode);
	}
}
